package hu.me.iit.gyak.gyak.service;

import hu.me.iit.gyak.gyak.repository.Licit;
import hu.me.iit.gyak.gyak.repository.LicitRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LicitServiceImpl implements LicitService{

    private final LicitRepository licitRepository;

    public LicitServiceImpl(LicitRepository licitRepository) {
        this.licitRepository = licitRepository;
    }

    @Override
    public int getHighest(){
        Optional<Licit> result = licitRepository.findTopByOrederByLicitDesc();
        if (result.isEmpty()){
            return 0;
        }
            return result.get().getLicit();
    }

    @Override
    public int getHighestForUser(int userId){
        Optional<Licit> result = licitRepository.findTopByUserIdAndOrderByLicitDesc(userId);
        if (result.isEmpty()){
            return 0;
        }
        return result.get().getLicit();
    }

    @Override
    public void saveNewLicit(int licit, int userId) {
        licitRepository.save(new Licit(licit, userId));
    }
}

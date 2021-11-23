package hu.me.iit.gyak.gyak.service;

public interface LicitService {
    int getHighest();

    int getHighestForUser(int userId);

    void saveNewLicit(int licit, int userId);
}

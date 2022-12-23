package hiber.service;

import hiber.model.User;

public interface CarService {
    User getUserByCar(String parModel, int parSeries);
}

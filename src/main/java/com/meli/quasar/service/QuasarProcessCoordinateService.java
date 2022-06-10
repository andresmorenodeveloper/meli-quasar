package com.meli.quasar.service;

import org.springframework.stereotype.Service;

import com.meli.quasar.model.Coordinate;

@Service
public class QuasarProcessCoordinateService {

	public Coordinate getCoordinate(Coordinate c1, Coordinate c2, Coordinate c3, double r1, double r2, double r3) {

		double d = getDistancePithagoricFormule(c1, c2);
		double exx = restPoints(c2, c1).getX() / d;
		double exy = restPoints(c2, c1).getY() / d;

		Coordinate ex = new Coordinate(exx, exy);
		Coordinate p31 = restPoints(c3, c1);
		double i = multiplyPoints(ex, p31);

		Coordinate ex_X_i = multiplyPoints(ex, i);
		double eyx = restPoints(p31, ex_X_i).getX() / getDistancePithagoricFormule(ex_X_i, p31);
		double eyy = restPoints(p31, ex_X_i).getY() / getDistancePithagoricFormule(ex_X_i, p31);

		Coordinate ey = new Coordinate(eyx, eyy);
		double j = multiplyPoints(ey, p31);

		double x = (Math.pow(r1, 2) - Math.pow(r2, 2) + Math.pow(d, 2)) / (2 * d);
		double y = ((Math.pow(r1, 2) - Math.pow(r3, 2) + Math.pow(i, 2) + Math.pow(j, 2)) / (2 * j)) - ((i / j) * x);

		Coordinate ex_X_x = multiplyPoints(ex, x);
		Coordinate ey_X_y = multiplyPoints(ey, y);

		double px = c1.getX() + ex_X_x.getX() + ey_X_y.getX();
		double py = c1.getY() + ex_X_x.getY() + ey_X_y.getY();

		return new Coordinate(px, py);
	}
	
	private double getDistancePithagoricFormule(Coordinate p1, Coordinate p2) {
		return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
	}

	private Coordinate restPoints(Coordinate p1, Coordinate p2) {
		return new Coordinate(p1.getX() - p2.getX(), p1.getY() - p2.getY());
	}

	private double multiplyPoints(Coordinate p1, Coordinate p2) {
		return p1.getX() * p2.getX() + p1.getY() * p2.getY();
	}

	private Coordinate multiplyPoints(Coordinate p1, double e) {
		return new Coordinate(p1.getX() * e, p1.getY() * e);
	}
	
}

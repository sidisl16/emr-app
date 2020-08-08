package com.emr.app.swing.views;

import java.util.concurrent.ConcurrentHashMap;

import javax.swing.JLayeredPane;

public enum Router {

	INSTANCE;

	private JLayeredPane layeredPane;
	private ConcurrentHashMap<Class, RoutingPanel> routes;

	private Router() {
		routes = new ConcurrentHashMap<>();
	}

	public void setLayeredPane(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
	}

	public void registerRoute(RoutingPanel route) {
		this.routes.put(route.getClass(), route);
	}

	public void route(Class route) {
		layeredPane.removeAll();
		RoutingPanel panel = routes.get(route);
		layeredPane.add(panel);
		layeredPane.revalidate();
		panel.execute();
	}

	public void routeWithData(Class route, Object... dtos) {
		layeredPane.removeAll();
		RoutingPanel panel = routes.get(route);
		layeredPane.add(panel);
		layeredPane.revalidate();
		panel.execute(dtos);
	}

}

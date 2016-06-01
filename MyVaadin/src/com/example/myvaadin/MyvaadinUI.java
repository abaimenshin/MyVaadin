package com.example.myvaadin;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import fi.jasoft.dragdroplayouts.DDPanel;
import fi.jasoft.dragdroplayouts.client.ui.LayoutDragMode;
import fi.jasoft.dragdroplayouts.drophandlers.DefaultPanelDropHandler;

@SuppressWarnings("serial")
//@Theme("myvaadin")
@Theme("valo")
public class MyvaadinUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MyvaadinUI.class)
	public static class Servlet extends VaadinServlet {
	}
	
	@Override
	protected void init(VaadinRequest request) {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        layout.setMargin(true);
        layout.setSpacing(true);
//        layout.addComponent(c);

        DDPanel panel1 = new DDPanel("Source");
        panel1.setWidth("200px");
        panel1.setHeight("200px");
        panel1.setDragMode(LayoutDragMode.CLONE);
        panel1.setDropHandler(new DefaultPanelDropHandler());
        layout.addComponent(panel1);

        Button content = new Button("Drag me!");
        content.setSizeFull();
        panel1.setContent(content);

        DDPanel panel2 = new DDPanel("Destination");
        panel2.setWidth("200px");
        panel2.setHeight("200px");
        panel2.setDragMode(LayoutDragMode.CLONE);
        panel2.setDropHandler(new DefaultPanelDropHandler());
        layout.addComponent(panel2);
        
        setContent(layout);
	}

}
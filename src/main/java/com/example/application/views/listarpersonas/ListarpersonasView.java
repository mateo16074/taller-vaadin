package com.example.application.views.listarpersonas;

import com.example.application.models.Persona;
import com.example.application.utils.Utils;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Listar personas")
@Route(value = "my-view", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class ListarpersonasView extends VerticalLayout {

    public ListarpersonasView() {
        Grid<Persona> grid = new Grid<>(Persona.class, false);
        grid.addColumn(Persona::obtenerNombre).setHeader("Nombre");
        grid.addColumn(Persona::obtenerEdad).setHeader("Edad");
        grid.addColumn(Persona::rol).setHeader("Rol");

        grid.setItems(Utils.personas);
        add(
                grid
        );
    }
}

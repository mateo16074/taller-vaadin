package com.example.application.views.agregarpersonas;

import com.example.application.models.Estudiante;
import com.example.application.models.Profesor;
import com.example.application.utils.Utils;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("Agregar personas")
@Route(value = "my-view2", layout = MainLayout.class)
@Uses(Icon.class)
public class AgregarpersonasView extends Composite<VerticalLayout> {
    HorizontalLayout layoutRow = new HorizontalLayout();
    TextField textNombre = new TextField();
    TextField textEdad = new TextField();
    HorizontalLayout layoutRow2 = new HorizontalLayout();
    Checkbox checkEstudiante = new Checkbox();
    HorizontalLayout layoutRow3 = new HorizontalLayout();
    Button buttonGuardar = new Button();
    Button buttonCancelar = new Button();

    public AgregarpersonasView() {

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("91px");
        textNombre.setLabel("Nombre");
        textNombre.setWidth("min-content");
        textEdad.setLabel("Edad");
        textEdad.setWidth("min-content");
        layoutRow2.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.setHeight("91px");
        checkEstudiante.setLabel("Estudiante");
        checkEstudiante.setWidth("min-content");
        layoutRow3.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow3);
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutRow3.setWidth("100%");
        layoutRow3.getStyle().set("flex-grow", "1");
        buttonGuardar.setText("Guardar");
        buttonGuardar.setWidth("min-content");
        buttonGuardar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        buttonGuardar.addClickListener(buttonClickEvent -> {
            String nombre = textNombre.getValue();
            int edad = Integer.parseInt(textEdad.getValue());

           if (checkEstudiante.getValue()){
               Estudiante estudiante = new Estudiante(nombre, edad);
               Utils.personas.add(estudiante);

           }else {
               Profesor profesor = new Profesor(nombre, edad);
               Utils.personas.add(profesor);

            }

            buttonGuardar.getUI().ifPresent(ui ->
                    ui.navigate("my-view"));
        });

        buttonCancelar.setText("Cancelar");
        buttonCancelar.setWidth("min-content");
        buttonCancelar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        buttonCancelar.addClickListener(buttonClickEvent ->{
            buttonCancelar.getUI().ifPresent(ui ->
                    ui.navigate("my-view"));
        });
        getContent().add(layoutRow);
        layoutRow.add(textNombre);
        layoutRow.add(textEdad);
        getContent().add(layoutRow2);
        layoutRow2.add(checkEstudiante);
        getContent().add(layoutRow3);
        layoutRow3.add(buttonGuardar);
        layoutRow3.add(buttonCancelar);
    }
}

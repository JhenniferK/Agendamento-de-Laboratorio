package ifpb.edu.br.main.view;

import ifpb.edu.br.main.controller.Controlador;

import java.awt.*;
import javax.swing.*;
import java.io.Serializable;

public class TelaPrincipal extends JPanel implements Serializable {
    private Controlador controlador;
    private final JanelaCalendario janelaCalendario;

    public TelaPrincipal() {
        controlador = Controlador.getInstance();
        System.out.println(controlador);
        this.setLayout(new BorderLayout());
        janelaCalendario = new JanelaCalendario(Controlador.getInstance());
        configurar();
    }

    public void configurar() {
        JPanel jPanel;
        jPanel = new JPanel(new BorderLayout());

        String[] stringMeses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro",
                "Outubro", "Novembro", "Dezembro"};

        JPanel topoPanel = new JPanel(new BorderLayout());
        topoPanel.add(jPanel, BorderLayout.NORTH);

        this.add(topoPanel, BorderLayout.NORTH);
        this.add(janelaCalendario, BorderLayout.CENTER);

        this.setSize(400, 300);
        this.setVisible(true);
    }

}

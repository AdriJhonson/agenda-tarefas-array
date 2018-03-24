package br.com.adrisilva.agendaarray.controller;

import br.com.adrisilva.agendaarray.model.Tarefa;

public class AgendaController {

    public Tarefa tarefa;
    public int qtd_tarefas_cadastradas;
    public Tarefa lista_tarefas[];

    public AgendaController() {
        this.lista_tarefas = new Tarefa[10];
        this.qtd_tarefas_cadastradas = 0;
    }

    public AgendaController(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public void criarTarefa(String desc, String data, double valor_hora, int hr_inicio, double duracao, String local) {

        boolean tarefa_repetida = false;

        for (int i = 0; i < this.qtd_tarefas_cadastradas; i++) {
            if (lista_tarefas[i].getDescricao().equals(desc)) {
                tarefa_repetida = true;
            }
        }

        if (tarefa_repetida) {
            System.err.println("Já existe uma tarefa cadastrada com essa descrição!!!");
        } else {
            int indice = this.qtd_tarefas_cadastradas;

            Tarefa t = new Tarefa(hr_inicio, valor_hora, duracao, desc, data, local);

            this.lista_tarefas[indice] = t;

            this.qtd_tarefas_cadastradas++;
            
            System.out.println("-> Tarefa Cadastrada com sucesso.");
        }

    }

    public void removerTarefa(String desc_tarefa) {

        Tarefa nova_lista_tarefas[] = new Tarefa[10];
        int qtd_tr = 0;
        int j = 0;

        for (int i = 0; i < this.qtd_tarefas_cadastradas; i++) {

            if (lista_tarefas[i].getDescricao().equals(desc_tarefa)) {
                this.lista_tarefas[i].setDescricao("remover");
                qtd_tr++;
            }

        }

        if (qtd_tr > 0) {
            for (int i = 0; i < this.qtd_tarefas_cadastradas; i++) {

                if (!this.lista_tarefas[i].getDescricao().equals("remover")) {
                    nova_lista_tarefas[j] = this.lista_tarefas[i];
                    ++j;
                }

            }

            this.lista_tarefas = nova_lista_tarefas;
            this.qtd_tarefas_cadastradas--;
            System.out.println("Tarefa Removida com sucesso");

        } else {
            System.err.println("Tarefa não encontrada!!! Verifique se a descrição está certa.");
        }

    }

    public void buscarTarefa(String desc_tarefa) {
        int qtd_tr = 0;

        for (int i = 0; i < this.qtd_tarefas_cadastradas; i++) {

            if (lista_tarefas[i].getDescricao().equals(desc_tarefa)) {
                String descricao = this.lista_tarefas[i].getDescricao();
                String status_sigla = this.lista_tarefas[i].getStatus();
                String status = "";
                String data = this.lista_tarefas[i].getData();
                String local = this.lista_tarefas[i].getLocal();
                int importancia = this.lista_tarefas[i].getImportancia();
                int hr_inicio = this.lista_tarefas[i].getHora_inicio();
                double valor_hora = this.lista_tarefas[i].getValor_hora();
                double valor_cobrado = this.lista_tarefas[i].getValor_cobrado();

                switch (status_sigla) {
                    case "P":
                        status = "Por fazer";
                        break;
                    case "A":
                        status = "Andamento";
                        break;
                    case "F":
                        status = "Feito";
                        break;
                }

                System.out.println("- - - - - Tarefa " + (i + 1) + "- - - - -");
                System.out.println("Descrição: " + descricao);
                System.out.println("Status: (" + status_sigla + ") -> " + status);
                System.out.println("Data: " + data);
                System.out.println("Hora Inicio: " + hr_inicio);
                System.out.println("Local: " + local);
                System.out.println("Importância: " + importancia);
                System.out.println("Valor Hora: R$ " + valor_hora);
                System.out.println("Valor Cobrado: R$ " + valor_cobrado);
                qtd_tr++;
            }

        }

        if (qtd_tr == 0) {
            System.err.println("Tarefa não encontrada!!! Verifique se a descrição está certa.");
        }

    }

    public void iniciarTarefa(String desc_tarefa) {
        int qtd_tr = 0;

        for (int i = 0; i < this.qtd_tarefas_cadastradas; i++) {
            if (lista_tarefas[i].getDescricao().equals(desc_tarefa)) {
                lista_tarefas[i].iniciarTarrefa();
                qtd_tr++;
            }
        }

        if (qtd_tr == 0) {
            System.err.println("Tarefa não encontrada!!! Verifique se a descrição está certa.");
        } else {
            System.out.println("-> Tarefa Iniciada.");
        }
    }

    public void encerrarTarefa(String desc_tarefa, double valor_cobrado) {
        int qtd_tr = 0;

        for (int i = 0; i < this.qtd_tarefas_cadastradas; i++) {
            if (lista_tarefas[i].getDescricao().equals(desc_tarefa)) {
                lista_tarefas[i].encerrarTarefa(valor_cobrado);
                qtd_tr++;
            }
        }

        if (qtd_tr == 0) {
            System.err.println("Tarefa não encontrada!!! Verifique se a descrição está certa.");
        } else {
            System.out.println("-> Tarefa Encerrada.");
        }
    }

    public void incrementarImportancia(String desc_tarefa) {
        int qtd_tr = 0;

        for (int i = 0; i < this.qtd_tarefas_cadastradas; i++) {
            if (lista_tarefas[i].getDescricao().equals(desc_tarefa)) {
                if (lista_tarefas[i].getImportancia() < 5) {
                    lista_tarefas[i].incrementarImportancia();
                    qtd_tr++;
                } else {
                    System.err.println("A importância dessa tarefa já está no maximizada.");
                    qtd_tr++;
                }
            }
        }

        if (qtd_tr == 0) {
            System.err.println("Tarefa não encontrada!!! Verifique se a descrição está certa.");
        } else {
            System.out.println("-> Importancia Aumentada.");
        }
    }

    public void mostrarTarefasCadastradas() {
        for (int i = 0; i < this.qtd_tarefas_cadastradas; i++) {

            String descricao = this.lista_tarefas[i].getDescricao();
            String status_sigla = this.lista_tarefas[i].getStatus();
            String status = "";
            String data = this.lista_tarefas[i].getData();
            String local = this.lista_tarefas[i].getLocal();
            int importancia = this.lista_tarefas[i].getImportancia();
            int hr_inicio = this.lista_tarefas[i].getHora_inicio();
            double valor_hora = this.lista_tarefas[i].getValor_hora();
            double valor_cobrado = this.lista_tarefas[i].getValor_cobrado();

            switch (status_sigla) {
                case "P":
                    status = "Por fazer";
                    break;
                case "A":
                    status = "Andamento";
                    break;
                case "F":
                    status = "Feito";
                    break;
            }

            System.out.println("- - - - - Tarefa " + (i + 1) + "- - - - -");
            System.out.println("Descrição: " + descricao);
            System.out.println("Status: (" + status_sigla + ") -> " + status);
            System.out.println("Data: " + data);
            System.out.println("Hora Inicio: " + hr_inicio);
            System.out.println("Local: " + local);
            System.out.println("Importância: " + importancia);
            System.out.println("Valor Hora: R$ " + valor_hora);
            System.out.println("Valor Cobrado: R$ " + valor_cobrado);
        }
    }

}

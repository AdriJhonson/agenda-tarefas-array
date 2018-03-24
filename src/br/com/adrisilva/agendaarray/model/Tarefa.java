package br.com.adrisilva.agendaarray.model;

public final class Tarefa {

    private int hora_inicio;
    private int importancia;
    private int urgencia;
    private double valor_hora;
    private double duracao;
    private String descricao;
    private String data;
    private String local;

    //Auto
    private int codigo;
    private String status;
    private double valor_cobrado;

    /*Status
    A - Em Andadamento
    P - Por fazes
    F - Feito
     */
    //Dúvida: CLASSE FINAL, oq é
    public Tarefa() {
        this.setStatus("P");
    }

    public Tarefa(int hr_incio, double valor_hora, double duracao, String desc, String data, String local) {
        this.setStatus("P");
        this.setHora_inicio(hr_incio);
        this.setLocal(local);
        this.setValor_hora(valor_hora);
        this.setDuracao(duracao);
        this.setDescricao(desc);
        this.setData(data);
        this.setImportancia(1);
        this.setUrgencia(1);
        this.valor_cobrado = 0;
        this.codigo += 1;
    }

    public void encerrarTarefa(double valor_cobrado) {
        this.valor_cobrado = valor_cobrado;
        this.setStatus("F");
    }

    public void iniciarTarrefa() {
        this.setStatus("A");

        double vh = this.getValor_hora();
        double dr = this.getDuracao();
        int imp = this.getImportancia();
        int urg = this.getUrgencia();

        this.valor_cobrado = vh + dr * ((imp + urg) / 2);
    }
    
    public void mostrarDados(){
        
        System.out.println("Descrição: " + this.getDescricao());
        System.out.println("Status: " + this.getStatus());
        System.out.println("Data: " + this.getData());
        System.out.println("Hora Inicio: " + this.getHora_inicio());
        System.out.println("Local: " + this.getLocal());
        System.out.println("Importância: " + this.getImportancia());
        System.out.println("Valor Hora: R$ " + this.getValor_hora());
        System.out.println("Valor Cobrado: R$ " + this.getValor_cobrado());
        
    }

    //Controle da importância e da urgência
    public void incrementarUrgencia() {
        this.urgencia += 1;
    }

    public void decrementarUrgencia() {
        this.urgencia -= 1;
    }

    public void incrementarImportancia() {
        this.importancia += 1;
    }

    public void decrementarImportancia() {
        this.importancia -= 1;
    }
    //-----------------------------------------

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(int hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public int getImportancia() {
        return importancia;
    }

    public void setImportancia(int importancia) {
        this.importancia = importancia;
    }

    public int getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(int urgencia) {
        this.urgencia = urgencia;
    }

    public double getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(double valor_hora) {
        this.valor_hora = valor_hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValor_cobrado() {
        return valor_cobrado;
    }

    public String getData() {
        return data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setData(String data) {
        this.data = data;
    }

}

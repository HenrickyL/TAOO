import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    static class Cliente{
        private boolean premium = false;
        public Cliente(String tipoCliente){
            this.premium = tipoCliente.equals("PREMIUM"); 
        }

        public boolean getPremium(){
            return this.premium;
        }
        public double calcularDesconto(double valor){
            if(!this.premium){
                return 0.0;
            }
            return valor * 0.10;
        }
    }
    static abstract class Entrega{
        private String nome = "RETIRADA";
        private double valor =  0.0;
        public Entrega(String nome, double valor){
            this.nome =nome;
            this.valor = valor;
        }
        public Entrega(String nome){
            this.nome =nome;
        }

        public String getNome() {
            return nome;
        }
        public double getValor() {
            return valor;
        }

        public double calcularFrete(double valorRestante){
            return this.valor;
        }
    }
    static class EntregaRetirada extends Entrega {
        public EntregaRetirada(){
            super("RETIRADA", 0.0);
        }
    }
    static class EntregaNormal extends Entrega{
        public EntregaNormal(){
            super("NORMAL", 12.0);
        }

        @Override
        public double calcularFrete(double valorRestante) {
            return valorRestante >= 150.0 ? 0 : this.getValor();
        }
    }

    static class EntregaExpressa extends Entrega{
        public EntregaExpressa(){
            super("EXPRESSA", 25.0);
        }
    }

    static class Item {
        private String categoria = "OUTRO"; // categoria
        private double preco; // preco
        private int quantidade; // quantidade
        protected double porcentagemDesconto = 0;

        public Item(String categoria, double preco, int quantidade, double porcentagem) {
            this.categoria = categoria;
            this.preco = preco;
            this.quantidade = quantidade;
            this.porcentagemDesconto = porcentagem;
        }
        public Item(double preco, int quantidade) {
            this.preco = preco;
            this.quantidade = quantidade;
        }

        public String getCategoria() {
            return categoria;
        }
        public double getPreco(){
            return this.preco;
        }
        public int getQuantidade(){
            return this.quantidade;
        }
        public double getPorcentagemDesconto() {
            return porcentagemDesconto;
        }

        public double calcularSubtotal(){
            return this.preco * this.quantidade;
        }

        public double calcularDesconto(){
            return this.calcularSubtotal() * this.porcentagemDesconto;
        }
    }

    static class ItemLivro extends Item{
        public ItemLivro(double preco, int quantidade){
            super("LIVRO", preco, quantidade, 0.05);
        }
    }
    static class ItemEletronico extends Item{
        public ItemEletronico(double preco, int quantidade){
            super("ELETRONICO", preco, quantidade, 0.02);
        }
    }

    static class ResultadoPedido{
        private double subtotal;
        private double desconto;
        private double frete;
        private double total;

        public ResultadoPedido(double subtotal, double desconto, double frete, double total){
            this.subtotal = subtotal;
            this.desconto = desconto;
            this.frete = frete;
            this.total = total;
        }
        public void imprimirResultado(){
            System.out.printf("SUBTOTAL=%.2f%n", subtotal);
            System.out.printf("DESCONTO=%.2f%n", desconto);
            System.out.printf("FRETE=%.2f%n", frete);
            System.out.printf("TOTAL=%.2f%n", total);
        }
    }
    static class Pedido {
        private  Cliente cliente;
        private Entrega entrega;
        private ArrayList<Item> items = new ArrayList<>();

        public Pedido(Cliente cliente, Entrega entrega){
            this.cliente = cliente;
            this.entrega = entrega;
        }

        public void addItem(Item item){
            this.items.add(item);
        }

        public ResultadoPedido calcularResultado() {
            double subtotal = 0.0;
            double desconto = 0.0;

            for (Item item : items) {
                subtotal += item.calcularSubtotal();
                desconto += item.calcularDesconto();
            }

            double valor = subtotal - desconto;
            double descontoPremium = cliente.calcularDesconto(valor);
            desconto += descontoPremium;
            valor -= descontoPremium;

            double frete = entrega.calcularFrete(valor);
            double total = valor + frete;

            return new ResultadoPedido(subtotal, desconto, frete, total);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //tipo do cliente
        Cliente cliente =  new Cliente(sc.nextLine().trim());
        
        //modalidade 
        String modalidadeEntrega = sc.nextLine().trim();
        Entrega entrega;
        if (modalidadeEntrega.equals("NORMAL")) {
            entrega = new EntregaNormal();
        } else if (modalidadeEntrega.equals("EXPRESSA")) {
            entrega = new EntregaExpressa();
        }else{
            entrega = new EntregaRetirada();
        }
        Pedido pedido = new Pedido(cliente, entrega);

        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String[] x = sc.nextLine().trim().split("\\s+");


            String nome = x[0];
            double preco = Double.parseDouble(x[1]);
            int qtd = Integer.parseInt(x[2]);
            Item item;
            if (nome.equals("LIVRO")) {
                item = new ItemLivro(preco, qtd);
            } else if (nome.equals("ELETRONICO")) {
                item = new ItemEletronico(preco, qtd);
            } else {
                item = new Item(preco, qtd);
            }
            //categorias
            pedido.addItem(
                item
            );
        }

        ResultadoPedido resultado = pedido.calcularResultado();
        resultado.imprimirResultado();

        sc.close();
    }
}
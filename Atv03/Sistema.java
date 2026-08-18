import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    static class Cliente{
        private boolean isPremium = false;
        public Cliente(String tipoCliente){
            this.isPremium = tipoCliente.equals("PREMIUM"); 
        }

        public boolean getIsPremium(){
            return this.isPremium;
        }
    }
    static class Entrega{
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
    }

    static class EntregaNormal extends Entrega{
        public EntregaNormal(){
            super("NORMAL", 12.0);
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

        public double calcularDesconto(double valor){
            return valor * this.porcentagemDesconto;
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

        public void x() {
            double subtotal = 0.0;
            double desconto = 0.0;

            for (Item item : items) {
                double valor =  item.calcularSubtotal();
                subtotal += valor;
                desconto += item.calcularDesconto(valor);
            }

            double valor = subtotal - desconto;

            if(cliente.getIsPremium()){
                double z = valor * 0.10;
                desconto = desconto + z;
                valor = valor - z;
            }

            double frete = 0.0;

            frete =  valor>=150.0 ? entrega.getValor() : 0;

            double total = valor + frete;

            System.out.printf("SUBTOTAL=%.2f%n", subtotal);
            System.out.printf("DESCONTO=%.2f%n", desconto);
            System.out.printf("FRETE=%.2f%n", frete);
            System.out.printf("TOTAL=%.2f%n", total);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //tipo do cliente
        Cliente cliente =  new Cliente(sc.nextLine().trim());
        
        //modalidade 
        String modalidadeEntrega = sc.nextLine().trim();
        Entrega entrega;
        if (modalidadeEntrega.equals("RETIRADA")) {
            entrega = new Entrega(modalidadeEntrega);
        } else if (modalidadeEntrega.equals("NORMAL")) {
            entrega = new EntregaNormal();
        } else if (modalidadeEntrega.equals("EXPRESSA")) {
            entrega = new EntregaExpressa();
        }
        Pedido pedido = new Pedido(cliente, entrega);

        int n = Integer.parseInt(sc.nextLine().trim());

        for (int k = 0; k < n; k++) {
            String[] x = sc.nextLine().trim().split("\\s+");


            String nome = x[0];
            double preco = Double.parseDouble(x[1]);
            int qtd = Integer.parseInt(x[2]);
            Item item;
            if (nome.equals("LIVRO")) {
                item = new ItemLivro(k, preco, qtd);
            } else if (nome.equals("ELETRONICO")) {
                item = new ItemEletronico(k, preco, qtd);
            } else if (nome.equals("OUTRO")) {
                item = new Item(k, preco, qtd);
            }
            //categorias
            pedido.addItem(
                item
            );
        }

        pedido.x();

        sc.close();
    }
}
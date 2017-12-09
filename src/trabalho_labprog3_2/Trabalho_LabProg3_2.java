package trabalho_labprog3_2;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mattheus
 */
public class Trabalho_LabProg3_2 {

    public static void main(String[] args) throws IOException {
        List<Item> dados = getMenu();
        List<Pedido> pedidos = getPedidos();

        JanelaCardapio janela = new JanelaCardapio(dados, pedidos);
        janela.setLocationRelativeTo(null);
        janela.setSize(1350, 600);
        janela.setLocation(0, 100);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }

    private static List<Item> getMenu() throws IOException {
        List<Item> itens = new ArrayList<Item>();

        try {
            Integer cod = 0;
            Scanner entrada = new Scanner(Paths.get("test/menu.txt"), "ISO-8859-1");
            while (entrada.hasNext()) {
                Double preco = Double.parseDouble(entrada.next());
                String aux1 = entrada.next();
                String titulo = aux1.replace("_", " ");
                String aux2 = entrada.next();
                String descricao = aux2.replace("_", " ");
                cod++;
                Item i = new Item(cod, titulo, descricao, preco);
                itens.add(i);
            }
            entrada.close();

        } catch (Exception e) {
            Logger.getLogger(Trabalho_LabProg3_2.class.getName()).log(Level.SEVERE, null, e);

        }

        return itens;
    }

    private static List<Pedido> getPedidos() throws IOException {
        List<Pedido> pedidos = new ArrayList<Pedido>();
        List<Item> menu = getMenu();

        try {
            Scanner entrada = new Scanner(Paths.get("test/cardapio.txt"), "UTF-8" );
            while (entrada.hasNext()) {
                Integer mesa = entrada.nextInt();
                List<Item> itens = new ArrayList<Item>();

                String aux1 = entrada.next();
                
                for (int i = 0; i < aux1.length(); i++) {
                    Integer k;
                    String a = String.valueOf(aux1.charAt(i));
                    k = Integer.parseInt(a);
                    itens.add(menu.get(k));
                }
                //insere itens

                Double preco = Double.parseDouble(entrada.next());

                long aux2 = entrada.nextLong();

                Date hr_entrada = new Date(aux2);

                long aux3 = entrada.nextLong();
                Date hr_saida = new Date(aux3);

                Pedido p = new Pedido(mesa, itens, preco, hr_entrada, hr_saida);
                p.setAberto(2);
                pedidos.add(p);

            }
            entrada.close();

        } catch (Exception e) {
            Logger.getLogger(Trabalho_LabProg3_2.class.getName()).log(Level.SEVERE, null, e);

        }

        return pedidos;
    }

}

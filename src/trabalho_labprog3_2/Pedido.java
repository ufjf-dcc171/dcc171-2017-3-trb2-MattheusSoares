package trabalho_labprog3_2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Mattheus
 */
public class Pedido {

    private Integer mesa;
    private List<Item> itens;
    private Double total;
    private Date horarioI;
    private Date horarioF;
    private long horarioI_L;
    private long horarioF_L;
    private Integer aberto = 0;

    public Pedido() {
    }

    public Pedido(Integer mesa, List<Item> itens, Double total) {
        this.mesa = mesa;
        this.itens = itens;
        this.total = total;
    }

    public Pedido(Integer mesa, List<Item> itens, Double total, Date horarioI, Date horarioF) {
        
        this.mesa = mesa;
        this.itens = itens;
        this.total = total;
        this.horarioI = horarioI;
        this.horarioF = horarioF;
    }

    public Integer getAberto() {
        return aberto;
    }

    public void setAberto(Integer aberto) {
        this.aberto = aberto;
    }

    public Integer getMesa() {
        return mesa;
    }

    public void setMesa(Integer mesa) {
        this.mesa = mesa;
    }

    public List<Item> getItens() {
        return this.itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public String getNomesItens() {
        String s = "";
        if (this.itens != null) {
            for (Item i : itens) {
                s += i.getNome() + " - ";
            }
        } else {
            s = "Não há pedidos nesta mesa";
        }
        return s;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public double calcularTotal() {
        double d = 0;
        if (this.itens != null) {
            for (Item i : itens) {
                d += i.getPreco();
            }
        }
        return d;

    }

    public Date getHorarioI() {
        return horarioI;
    }

    public void setHorarioI(long h) {
        Date date = new Date(h);
        this.horarioI = date;
    }

    public Date getHorarioF() {
        return horarioF;
    }

    public void setHorarioF(long h) {
        Date date = new Date(h);
        this.horarioF = date;
    }
    @Override
    public String toString() {
        return "Mesa: " + this.mesa.toString();
    }

    public long getHorarioI_L() {
        return horarioI_L;
    }

    public void setHorarioI_L(long horarioI_L) {
        this.horarioI_L = horarioI_L;
    }

    public long getHorarioF_L() {
        return horarioF_L;
    }

    public void setHorarioF_L(long horarioF_L) {
        this.horarioF_L = horarioF_L;
    }

}

package project.delivery.cart;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import project.delivery.client.ClientEntity;
import project.delivery.item.ItemEntity;
import project.delivery.payment.Payment;

@Entity
@Table(name = "cart")
public class CartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double total;
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name="item")
	private List<ItemEntity> itens;
	@Enumerated(EnumType.STRING)
	private Payment payment;
	@OneToOne
	private ClientEntity client;

	public CartEntity() {

	}

	public CartEntity(Long id, double total, List<ItemEntity> itens, Payment payment, ClientEntity client) {
		super();
		this.id = id;
		this.total = total;
		this.itens = itens;
		this.payment = payment;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<ItemEntity> getItens() {
		return itens;
	}

	public void setItens(List<ItemEntity> itens) {
		this.itens = itens;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public ClientEntity getClient() {
		return client;
	}

	public void setClient(ClientEntity client) {
		this.client = client;
	}
}
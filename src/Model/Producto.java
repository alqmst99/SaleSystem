
package Model;

/**
 *
 * @author Nahuel Pierini
* @Enterprise: FSTailSolution
 */
public class Producto {
private int Id;
private String codigo;
private String nombre;
private String proveedor;
private int stock;
private double precio;


//Constructors void, an all
    public Producto() {
    }

    public Producto(int Id, String codigo, String nombre, String proveedor, int stock, double precio) {
        this.Id = Id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.stock = stock;
        this.precio = precio;
    }
//Getters & Setters

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}

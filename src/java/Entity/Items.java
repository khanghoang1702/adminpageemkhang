/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Items.findAll", query = "SELECT i FROM Items i"),
    @NamedQuery(name = "Items.findByItemID", query = "SELECT i FROM Items i WHERE i.itemID = :itemID"),
    @NamedQuery(name = "Items.findByItemName", query = "SELECT i FROM Items i WHERE i.itemName = :itemName"),
    @NamedQuery(name = "Items.findByItemPrice", query = "SELECT i FROM Items i WHERE i.itemPrice = :itemPrice"),
    @NamedQuery(name = "Items.findByItemQuantity", query = "SELECT i FROM Items i WHERE i.itemQuantity = :itemQuantity"),
    @NamedQuery(name = "Items.findByItemPhoto", query = "SELECT i FROM Items i WHERE i.itemPhoto = :itemPhoto"),
    @NamedQuery(name = "Items.findByItemPhotoPath", query = "SELECT i FROM Items i WHERE i.itemPhotoPath = :itemPhotoPath")})
public class Items implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "itemID")
    private String itemID;
    @Basic(optional = false)
    @Column(name = "itemName")
    private String itemName;
    @Basic(optional = false)
    @Column(name = "itemPrice")
    private double itemPrice;
    @Basic(optional = false)
    @Column(name = "itemQuantity")
    private int itemQuantity;
    @Basic(optional = false)
    @Column(name = "itemPhoto")
    private String itemPhoto;
    @Basic(optional = false)
    @Column(name = "itemPhotoPath")
    private String itemPhotoPath;

    public Items() {
    }

    public Items(String itemID) {
        this.itemID = itemID;
    }

    public Items(String itemID, String itemName, double itemPrice, int itemQuantity, String itemPhoto, String itemPhotoPath) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.itemPhoto = itemPhoto;
        this.itemPhotoPath = itemPhotoPath;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getItemPhoto() {
        return itemPhoto;
    }

    public void setItemPhoto(String itemPhoto) {
        this.itemPhoto = itemPhoto;
    }

    public String getItemPhotoPath() {
        return itemPhotoPath;
    }

    public void setItemPhotoPath(String itemPhotoPath) {
        this.itemPhotoPath = itemPhotoPath;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemID != null ? itemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Items)) {
            return false;
        }
        Items other = (Items) object;
        if ((this.itemID == null && other.itemID != null) || (this.itemID != null && !this.itemID.equals(other.itemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Items[ itemID=" + itemID + " ]";
    }
    
}

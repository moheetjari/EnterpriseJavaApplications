/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "block")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Block.findAll", query = "SELECT b FROM Block b"),
    @NamedQuery(name = "Block.findById", query = "SELECT b FROM Block b WHERE b.id = :id"),
    @NamedQuery(name = "Block.findByFileName", query = "SELECT b FROM Block b WHERE b.fileName = :fileName"),
    @NamedQuery(name = "Block.findByTimeStamp", query = "SELECT b FROM Block b WHERE b.timeStamp = :timeStamp")})
public class Block implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "Data")
    private String data;
    @Basic(optional = false)
    @Column(name = "FileName")
    private String fileName;
    @Basic(optional = false)
    @Column(name = "TimeStamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;
    @Basic(optional = false)
    @Lob
    @Column(name = "Hash")
    private String hash;
    @Basic(optional = false)
    @Lob
    @Column(name = "PreviousHash")
    private String previousHash;

    public Block() {
    }

    public Block(Integer id) {
        this.id = id;
    }

    public Block(Integer id, String data, String fileName, Date timeStamp, String hash, String previousHash) {
        this.id = id;
        this.data = data;
        this.fileName = fileName;
        this.timeStamp = timeStamp;
        this.hash = hash;
        this.previousHash = previousHash;
    }

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.hash = calculateHash();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Block)) {
            return false;
        }
        Block other = (Block) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Block[ id=" + id + " ]";
    }

    public String calculateHash() {

        String input = this.data + this.previousHash;
        StringBuilder hexString = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] b = md.digest(input.getBytes(StandardCharsets.UTF_8));
            BigInteger number = new BigInteger(1, b);
            hexString = new StringBuilder(number.toString(16));
            while (hexString.length() < 32) {
                hexString.insert(0, '0');
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return hexString.toString();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Block;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author admin
 */
@Stateless
public class BlockChainBean implements BlockChainBeanLocal {
    
    @PersistenceContext(unitName = "BlockChainPU")
    EntityManager em;
    
    @Override
    public List<Block> getAllBlock() {
        return em.createNamedQuery("Block.findAll").getResultList();
    }
    
    @Override
    public void generateGenesis() {
        Block block = new Block("Hello rakesh!!", "0");
        em.persist(block);
    }
    
    @Override
    public void addBlock(Block block) {
        Block b = block;
        b.setPreviousHash(getAllBlock().get(getAllBlock().size() - 1).getHash());
        b.setHash(b.calculateHash());
        em.persist(b);
    }
    
    @Override
    public void displayChain() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Block getLatestBlock() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

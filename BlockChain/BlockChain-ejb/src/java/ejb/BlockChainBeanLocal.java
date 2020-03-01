/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Block;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface BlockChainBeanLocal {

    public List<Block> getAllBlock();

    public void generateGenesis();

    public void addBlock(Block block);

    public void displayChain();

    public Block getLatestBlock();
}

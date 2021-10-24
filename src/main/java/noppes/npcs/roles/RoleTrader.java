package noppes.npcs.roles;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.NoppesUtilPlayer;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.NpcMiscInventory;
import noppes.npcs.constants.EnumGuiType;
import noppes.npcs.entity.EntityNPCInterface;
import foxz.utils.Market;

public class RoleTrader extends RoleInterface{

    public String marketName = "";
	public NpcMiscInventory inventoryCurrency;
	public NpcMiscInventory inventorySold;

	public boolean ignoreDamage = false;
	public boolean ignoreNBT = false;
	public int pageCount = 1;
	public boolean toSave = false;
	
	public RoleTrader(EntityNPCInterface npc) {
		super(npc);
		inventoryCurrency = new NpcMiscInventory(1 * 9);
		inventorySold = new NpcMiscInventory(1 * 9);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbttagcompound) {
        nbttagcompound.setString("TraderMarket", marketName);
        nbttagcompound.setInteger("PageCount", pageCount);
		writeNBT(nbttagcompound);
        if (toSave && !npc.isRemote()) {
            Market.save(this, marketName);
        }
        toSave = false;
        return nbttagcompound;
	}

	public NBTTagCompound writeNBT(NBTTagCompound nbttagcompound) {
    	nbttagcompound.setTag("TraderCurrency", inventoryCurrency.getToNBT());
    	nbttagcompound.setTag("TraderSold", inventorySold.getToNBT());
        nbttagcompound.setBoolean("TraderIgnoreDamage", ignoreDamage);
        nbttagcompound.setBoolean("TraderIgnoreNBT", ignoreNBT);
        nbttagcompound.setInteger("PageCount", pageCount);
        return nbttagcompound;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbttagcompound) {
        marketName = nbttagcompound.getString("TraderMarket");
		readNBT(nbttagcompound);
        
    	try {
			Market.load(this, marketName);
		} catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
			
		}
	}

	public void readNBT(NBTTagCompound nbttagcompound) {
		inventoryCurrency.setFromNBT(nbttagcompound.getCompoundTag("TraderCurrency"));
		inventorySold.setFromNBT(nbttagcompound.getCompoundTag("TraderSold"));
        ignoreDamage = nbttagcompound.getBoolean("TraderIgnoreDamage");
        ignoreNBT = nbttagcompound.getBoolean("TraderIgnoreNBT");
        pageCount = nbttagcompound.getInteger("PageCount");
        
	}
	
	@Override
	public void interact(EntityPlayer player) {
		npc.say(player, npc.advanced.getInteractLine());
        try {
        	Market.load(this, marketName);
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
		NoppesUtilServer.sendOpenGui(player, EnumGuiType.PlayerTrader, npc);
	}

	public boolean hasCurrency(ItemStack itemstack) {
		if(itemstack == null)
			return false;
		for(ItemStack item : inventoryCurrency.items.values()){
			if(item != null && NoppesUtilPlayer.compareItems(item, itemstack, ignoreDamage, ignoreNBT)){
				return true;
			}
		}
		return false;
	}

}

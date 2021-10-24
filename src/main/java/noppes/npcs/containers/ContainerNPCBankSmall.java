package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerNPCBankSmall extends ContainerNPCBankInterface{
	   
    public ContainerNPCBankSmall(EntityPlayer player, int slot, int bankid)
    {
    	
    	super(player,slot,bankid);
    	
    }
    public boolean isAvailable(){
    	return true;
    }
    public int getRowNumber() {
		return 3;
	}
    
    
    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (p_82846_2_ < 3 * 9)
            {
                if (!this.mergeItemStack(itemstack1, 3 * 9, this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, 3 * 9, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }
    
    
}

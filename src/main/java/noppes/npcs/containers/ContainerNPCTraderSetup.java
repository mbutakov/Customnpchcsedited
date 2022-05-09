package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import noppes.npcs.entity.EntityNPCInterface;
import noppes.npcs.roles.RoleTrader;

public class ContainerNPCTraderSetup extends Container
{
	public RoleTrader role;
	
    public ContainerNPCTraderSetup(EntityNPCInterface npc,EntityPlayer player)
    {
        role = (RoleTrader) npc.roleInterface;
        for(int i = 0; i < (role.pageCount >= 4 ? 4*9 : role.pageCount * 9); i++)
        {
        	int x = -12;
        	x += i%3 * 48;
        	int y = 2;
        	y += i/3 * 18;
        	addSlotToContainer(new Slot(role.inventoryCurrency, i, x + 18, y));
        	addSlotToContainer(new SlotSold(role.inventorySold, i, x + 43, y));
        }   
        if(role.pageCount > 4) {
            for(int i = 4*9; i < role.pageCount*9 ; i++)
            {
            	int x = 128;
            	x += i%3 * 48;
            	int y = -213;
            	y += i/3 * 18;
            	addSlotToContainer(new Slot(role.inventoryCurrency, i, x + 18, y));
            	addSlotToContainer(new SlotSold(role.inventorySold, i, x + 43, y));
            }   
        }
     	addSlotToContainer(new SlotMoney(role.inventoryThreeMoneyItem, 0, 320 + 43, 5,34));
     	addSlotToContainer(new SlotMoney(role.inventoryThreeMoneyItem, 1, 320 + 60, 5,24));
     	addSlotToContainer(new SlotMoney(role.inventoryThreeMoneyItem, 2, 320 + 78, 5,14));
        for(int i1 = 0; i1 < 3; i1++){
            for(int l1 = 0; l1 < 9; l1++){
            	addSlotToContainer(new Slot(player.inventory, l1 + i1 * 9 + 9, 250 + l1 * 18, 130 + i1 * 18));
            }

        }

        for(int j1 = 0; j1 < 9; j1++){
        	addSlotToContainer(new Slot(player.inventory, j1, 250 + j1 * 18, 190));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int i)
    {
        return null;
    }
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return true;
	}
}

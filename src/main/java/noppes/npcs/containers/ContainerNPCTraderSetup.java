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
        
        for(int i = 0; i < 24; i++)
        {
        	int x = 6;
        	x += i%3 * 94;
        	int y = 10;
        	y += i/3 * 22;
        	addSlotToContainer(new Slot(role.inventoryCurrency, i + 24, x, y));
        	addSlotToContainer(new Slot(role.inventoryCurrency, i, x + 19, y));
        	addSlotToContainer(new Slot(role.inventorySold, i, x + 43, y));

        }   

        for(int i1 = 0; i1 < 3; i1++){
            for(int l1 = 0; l1 < 9; l1++){
            	addSlotToContainer(new Slot(player.inventory, l1 + i1 * 9 + 9, 48 + l1 * 18, 185 + i1 * 18));
            }

        }

        for(int j1 = 0; j1 < 9; j1++){
        	addSlotToContainer(new Slot(player.inventory, j1, 48 + j1 * 18, 242));
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

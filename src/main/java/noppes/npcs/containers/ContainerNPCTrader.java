package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import noppes.npcs.NoppesUtilPlayer;
import noppes.npcs.entity.EntityNPCInterface;
import noppes.npcs.roles.RoleTrader;


public class ContainerNPCTrader extends ContainerNpcInterface{
	public RoleTrader role;

    public ContainerNPCTrader(EntityNPCInterface npc,EntityPlayer player){
    	super(player);
        role = (RoleTrader) npc.roleInterface;
        int totalminusY = 0;
        for(int i = 0; i < 9 * role.pageCount; i++){
        	int x =  39;
        	x += i%3 * 55;
        	int y = 42;
        	y +=  i%9/3 * 36 -2;
			ItemStack item = role.inventoryCurrency.items.get(i);
			ItemStack item2 = role.inventoryCurrency.items.get(i + 24);
			if(item == null){
				item = item2;
				item2 = null;
			}
			addSlotToContainer(new SlotSold(role.inventorySold, i, x,y - totalminusY));
        }

        for (byte b = 0; b < 3; b++) {
            for (byte b1 = 0; b1 < 9; b1++)
              addSlotToContainer(new Slot(player.inventory, b1 + b * 9 + 9, 8 + b1 * 18, 158 + b * 18)); 
          } 
        

        for (byte b = 0; b < 9; b++) {
        	 addSlotToContainer(new Slot(player.inventory, b, 8 + b * 18, 212)); 
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int i){
        return null;
    }
    @Override
    public ItemStack slotClick(int i, int j, int par3, EntityPlayer entityplayer){
    	if(par3 == 6)
    		par3 = 0;
    	if(i < 0 || i >= 9 * role.pageCount)
        	return super.slotClick(i, j, par3, entityplayer);
		if( j ==1 )
			return null;
        Slot slot = (Slot)inventorySlots.get(i);
        if(slot == null || slot.getStack() == null)
        	return null;
        ItemStack item = slot.getStack();
    	
        if(!canGivePlayer(item, entityplayer))
        	return null;
        if(!canBuy(i, entityplayer))
        	return null;
        NoppesUtilPlayer.consumeItem(entityplayer, role.inventoryCurrency.getStackInSlot(i), role.ignoreDamage, role.ignoreNBT);
        ItemStack soldItem = item.copy();
        givePlayer(soldItem, entityplayer);
        return soldItem;
    	
    }
    public boolean canBuy(int slot, EntityPlayer player) {
		ItemStack currency = role.inventoryCurrency.getStackInSlot(slot);
		ItemStack currency2 = role.inventoryCurrency.getStackInSlot(slot);
		if(currency == null && currency2 == null)
			return true;
		if(currency == null){
			currency = currency2;
			currency2 = null;
		}
		if(NoppesUtilPlayer.compareItems(currency, currency2, role.ignoreDamage, role.ignoreNBT)){
			currency = currency.copy();
			currency2 = null;
		}
		if(currency2 == null )
			return NoppesUtilPlayer.compareItems(player, currency, role.ignoreDamage, role.ignoreNBT);
		return NoppesUtilPlayer.compareItems(player, currency, role.ignoreDamage, role.ignoreNBT) && NoppesUtilPlayer.compareItems(player, currency2, role.ignoreDamage, role.ignoreNBT);
		
    }

	private boolean canGivePlayer(ItemStack item,EntityPlayer entityplayer){//check Item being held with the mouse
        ItemStack itemstack3 = entityplayer.inventory.getItemStack();
        if(itemstack3 == null){
        	return true;
        }
        else if(NoppesUtilPlayer.compareItems(itemstack3, item, false, false)){
            int k1 = item.stackSize;
            if(k1 > 0 && k1 + itemstack3.stackSize <= itemstack3.getMaxStackSize())
            {
                return true;
            }
        }
        return false;
    }
    private void givePlayer(ItemStack item,EntityPlayer entityplayer){//set item bought to the held mouse item
    	
    if(isFullPlayerInventory(entityplayer)) {
        ItemStack itemstack3 = entityplayer.inventory.getItemStack();
        if(itemstack3 == null){
        	entityplayer.inventory.setItemStack(item);
        }
        else if(NoppesUtilPlayer.compareItems(itemstack3, item, false, false)){

            int k1 = item.stackSize;
            if(k1 > 0 && k1 + itemstack3.stackSize <= itemstack3.getMaxStackSize())
            {
                itemstack3.stackSize += k1;
            }
        }
    }else {
    	entityplayer.inventory.addItemStackToInventory(item);
    }
    }
    
	public boolean isFullPlayerInventory(EntityPlayer player) {
		for (int i = 0; i < 36; ++i) {
			ItemStack slot = player.inventory.getStackInSlot(i);
			if (slot == null) return false;
		}
		return true;
	}
}

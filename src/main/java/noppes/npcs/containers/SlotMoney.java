package noppes.npcs.containers;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class SlotMoney  extends Slot{

	public int count;
	public SlotMoney(IInventory p_i1824_1_, int index, int x, int y,int count) {
		super(p_i1824_1_, index, x, y);
		this.count = count;
		// TODO Auto-generated constructor stub
	}
}

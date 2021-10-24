package noppes.npcs.containers;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class SlotSold  extends Slot{

	public boolean isHide;
	public int prevPosY;
	
	public SlotSold(IInventory p_i1824_1_, int index, int x, int y) {
		super(p_i1824_1_, index, x, y);
		// TODO Auto-generated constructor stub
	}

	public void setHide() {
		prevPosY = this.yDisplayPosition;
		isHide = true;
		yDisplayPosition = -9999;
	}
	
	public void unHide() {
		yDisplayPosition = prevPosY;
		isHide = false;
	}
}


package noppes.npcs.client.gui.roles;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.NpcMiscInventory;
import noppes.npcs.client.Client;
import noppes.npcs.client.CustomNpcResourceListener;
import noppes.npcs.client.gui.player.GuiNPCTrader.Button;
import noppes.npcs.client.gui.util.GuiContainerNPCInterface2;
import noppes.npcs.client.gui.util.GuiMenuTopButton;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcButtonYesNo;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.constants.EnumPacketServer;
import noppes.npcs.containers.ContainerNPCTraderSetup;
import noppes.npcs.containers.SlotSold;
import noppes.npcs.entity.EntityNPCInterface;
import noppes.npcs.roles.RoleTrader;

import org.lwjgl.opengl.GL11;


/*#     # ######  #     # #######    #    #    # ####### #     #         
##   ## #     # #     #    #      # #   #   #  #     # #     #         
# # # # #     # #     #    #     #   #  #  #   #     # #     #         
#  #  # ######  #     #    #    #     # ###    #     # #     #         
#     # #     # #     #    #    ####### #  #   #     #  #   #          
#     # #     # #     #    #    #     # #   #  #     #   # #           
#     # ######   #####     #    #     # #    # #######    #            
                                                               ####### */
                                                               
public class GuiNpcTraderSetup extends GuiContainerNPCInterface2 implements ITextfieldListener{
	
	private final ResourceLocation slot = new ResourceLocation("customnpcs","textures/gui/slot.png");
	private RoleTrader role;
	private static int pageNumber = 1;
	private ContainerNPCTraderSetup container;
	private EntityNPCInterface npc;
    public GuiNpcTraderSetup(EntityNPCInterface npc, ContainerNPCTraderSetup container){
        super(npc, container);
        ySize = 220;
    	menuYOffset = -10;
    	role = container.role;
    	drawDefaultBackground = true;
    	this.container = container;
    	pageNumber = 1;
    }
    
	@Override
    public void initGui(){
    	super.initGui();
        buttonList.clear();

        addLabel(new GuiNpcLabel(1, "gui.ignoreDamage", guiLeft + 290, guiTop + 29));
        addButton(new GuiNpcButtonYesNo(1, guiLeft + 365, guiTop + 24, role.ignoreDamage));
        
        addLabel(new GuiNpcLabel(2, "gui.ignoreNBT", guiLeft + 300, guiTop + 51));
        addButton(new GuiNpcButton(6, this.width - 20, 0, 20, 20, "X"));
        addButton(new GuiNpcButtonYesNo(6, guiLeft + 365, guiTop + 46, true));
        addLabel(new GuiNpcLabel(4, "Page count", guiLeft + 285, guiTop + 75));
        addLabel(new GuiNpcLabel(5, "После установки страниц закрой npc и только после этого ложи вещи", guiLeft + 285, guiTop + 85));
        addTextField(new GuiNpcTextField(4, this, guiLeft + 285, guiTop + 100, 20, 20, role.pageCount +""));
	//	buttonList.add(new Button(-1, guiLeft + 250, guiTop + 200,70,10, ">"));
  //      buttonList.add(new Button(-2, guiLeft + 160, guiTop + 200,70,10, "<"));

    }

	@Override
    public void drawScreen(int i, int j, float f){
    	super.drawScreen(i, j, f);

    }

    @Override
    public void actionPerformed(GuiButton guibutton){
    	if(guibutton.id == 6) {
    		if(npc != null){
    			npc.reset();
    			Client.sendData(EnumPacketServer.NpcMenuClose);
    			mc.displayGuiScreen(null);
    	        mc.setIngameFocus();
    		}
    	}
    	if(guibutton.id == 1){
    		role.ignoreDamage = ((GuiNpcButtonYesNo)guibutton).getBoolean();
    	}
    	if(guibutton.id == 2){
    		role.ignoreNBT = ((GuiNpcButtonYesNo)guibutton).getBoolean();
    	}
    	
    	
		if(guibutton.id == -1) {
			if(pageNumber < role.pageCount) {
				pageNumber++;
  				for(int i = (pageNumber == 2 ? 0 : (pageNumber-2) * 9); i < (pageNumber == 2 ? 9 : (pageNumber-1) * 9); i++) {
  					if(container.getSlot(i) instanceof SlotSold) {
  						((SlotSold)container.getSlot(i)).setHide();
  					}else {
  						i++;
  					}
				}
			}
		}else {
			if(pageNumber > 1) {
				int s = pageNumber;
				pageNumber--;
//  				for(int i = (pageNumber-1) * 9 ; i <  pageNumber*9; i++) {
//  					((SlotSold)container.getSlot(i)).setHide();
//  				}	
//  				pageNumber--;
//  				for(int i = (pageNumber-1) * 9 ; i <  pageNumber*9; i++) {
//  					((SlotSold)container.getSlot(i)).unHide();
//  				}	
			}
		}
		
    }

	@Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j){
        	super.drawGuiContainerBackgroundLayer(f, i, j);
    		drawCenteredString(fontRendererObj, pageNumber + "/" + role.pageCount, this.xSize / 2 - 11, this.ySize+40, 16777215);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		if (role.pageCount > 4) {
			for (int slot = 4 * 9; slot < 9 * role.pageCount; slot++) {
				int x = slot % 3 * 48 + guiLeft + 128;
				int y = slot / 3 * 18 + guiTop - 215;
				mc.renderEngine.bindTexture(this.slot);
				GL11.glColor4f(1, 1, 1, 1);
				drawTexturedModalRect(x + 17, y, 0, 0, 18, 18);
				fontRendererObj.drawString("=", x + 36, y + 5, 16777215);
				mc.renderEngine.bindTexture(this.slot);
				GL11.glColor4f(1, 1, 1, 1);
				drawTexturedModalRect(x + 42, y, 0, 0, 18, 18);
			}
		}
		for (int slot = 0; slot <(role.pageCount >= 4 ? 4*9 : role.pageCount * 9); slot++) {
			int x = slot % 3 * 48 + guiLeft - 12;
			int y = slot / 3 * 18 + guiTop + 1;
			mc.renderEngine.bindTexture(this.slot);
			GL11.glColor4f(1, 1, 1, 1);
			drawTexturedModalRect(x + 17, y, 0, 0, 18, 18);
			fontRendererObj.drawString("=", x + 36, y + 5, 16777215);
			mc.renderEngine.bindTexture(this.slot);
			GL11.glColor4f(1, 1, 1, 1);
			drawTexturedModalRect(x + 42, y, 0, 0, 18, 18);
		}

    }
	
	@Override
	public void save() {
		
		Client.sendData(EnumPacketServer.TraderMarketSave, role.marketName, false);
		Client.sendData(EnumPacketServer.RoleSave, role.writeToNBT(new NBTTagCompound()));
	}
	
	@Override
	public void unFocused(GuiNpcTextField guiNpcTextField) {
		role.pageCount = Integer.parseInt(guiNpcTextField.getText());
		role.inventoryCurrency = new NpcMiscInventory(role.pageCount * 9);
		role.inventorySold = new NpcMiscInventory(role.pageCount * 9);
//		String name = guiNpcTextField.getText();
//		if(!name.equalsIgnoreCase(role.marketName)){
//			role.marketName = name;
//			Client.sendData(EnumPacketServer.TraderMarketSave, role.marketName, true);
//		}
			
	}
}

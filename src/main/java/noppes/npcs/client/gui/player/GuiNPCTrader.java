package noppes.npcs.client.gui.player;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import noppes.npcs.NoppesUtilPlayer;
import noppes.npcs.client.CustomNpcResourceListener;
import noppes.npcs.client.gui.util.GuiContainerNPCInterface;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcButtonYesNo;
import noppes.npcs.containers.ContainerNPCTrader;
import noppes.npcs.containers.SlotSold;
import noppes.npcs.entity.EntityNPCInterface;
import noppes.npcs.roles.RoleTrader;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class GuiNPCTrader extends GuiContainerNPCInterface{
	private final ResourceLocation resource = new ResourceLocation("customnpcs","textures/gui/trader.png");
	private final ResourceLocation resourceHcs = new ResourceLocation("customnpcs","textures/gui/trade.png");
	private final ResourceLocation slot = new ResourceLocation("customnpcs","textures/gui/slot.png");
	private RoleTrader role;
	private ContainerNPCTrader container;
	private ArrayList<Pages> pages;
	private ArrayList<Integer> standartPosition = new ArrayList<Integer>();
	private static int pageNumber = 1;
	
    public GuiNPCTrader(EntityNPCInterface npc, ContainerNPCTrader container){
        super(npc, container);
        this.container = container;
        role = (RoleTrader) npc.roleInterface;
        closeOnEsc = true;
        this.ySize = 236;
        this.title = npc.getCommandSenderName();
        pageNumber = 1;
        drawDefaultBackground = true;
    }
    
    public void initGui() {
    	super.initGui();
    	initImpl();
    }

    
    public static class Button extends GuiButton {
    	public Button(int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, String param1String) {
        super(param1Int1, param1Int2, param1Int3, param1Int4, param1Int5, param1String + "");
      }
      public void drawButton(Minecraft m, int param1Int1, int param1Int2)
      {
          if (this.visible) {
              boolean bool = mousePressed(m, param1Int1, param1Int2);
              drawRect(this.xPosition, this.yPosition, xPosition + width, this.yPosition + this.height, bool ? -2130706433 : 1895825407);
              drawCenteredString(Minecraft.getMinecraft().fontRenderer, this.displayString ,this.xPosition + this.width / 2, this.yPosition + height / 2 - 4, bool ? 16777088 : 16777215);
            }   
      }
    }
    
    private void initImpl() {
    		buttonList.add(new Button(-1, guiLeft + 100, guiTop + 145,70,10, ">"));
            buttonList.add(new Button(-2, guiLeft + 6, guiTop + 145,70,10, "<"));
          	if(standartPosition.size() < 1) {
                for(int i = 0; i < 9; i++) {
                	standartPosition.add(container.getSlot(i).yDisplayPosition);
                }
                for(int i = 9; i < 9*role.pageCount; i++) {
                ((SlotSold)container.getSlot(i)).setHide();
                }
        	}
    
    }

    
    public void actionPerformed(GuiButton guibutton){
    		if(guibutton.id == -1) {
    			if(pageNumber < role.pageCount) {
    				pageNumber++;
      				for(int i = (pageNumber == 2 ? 0 : (pageNumber-2) * 9); i < (pageNumber == 2 ? 9 : (pageNumber-1) * 9); i++) {
      					((SlotSold)container.getSlot(i)).setHide();
    				}
      				for(int i = (pageNumber-1) * 9 ; i <  pageNumber*9; i++) {
      					((SlotSold)container.getSlot(i)).unHide();
      				}
    			}
    		}else {
    			if(pageNumber > 1) {
    				int s = pageNumber;
    				
      				for(int i = (pageNumber-1) * 9 ; i <  pageNumber*9; i++) {
      					((SlotSold)container.getSlot(i)).setHide();
      				}	
      				pageNumber--;
      				for(int i = (pageNumber-1) * 9 ; i <  pageNumber*9; i++) {
      					((SlotSold)container.getSlot(i)).unHide();
      				}	
    			}
    		}
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(float paramFloat, int paramInt1, int paramInt2) {
    	
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        mc.renderEngine.bindTexture(resourceHcs);
        drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        for (paramInt1 = this.guiTop + 36; paramInt1 < this.guiTop + 142; paramInt1 += 36) {
            for (paramInt2 = this.guiLeft + 6; paramInt2 < this.guiLeft + 169; paramInt2 += 55) {
                drawTexturedModalRect(paramInt2, paramInt1, 176, 0, 53, 34); 
	        }
	    }
        
    	GL11.glPushMatrix();
    
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glColor4f(1.0F, 1F, 1.0F, 0.75F);
        RenderHelper.enableGUIStandardItemLighting();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glEnable(GL11.GL_LIGHTING);
		for(int slot = pageNumber == 1 ? 0 : (pageNumber-1) * 9; slot < pageNumber*9; slot++){
			int x = guiLeft + slot%3 * 55;
			int y = guiTop + slot%9/3 * 36 + 39;
			ItemStack item = role.inventoryCurrency.items.get(slot);
			ItemStack sold = role.inventorySold.items.get(slot);
	        GL11.glColor4f(0.39f, 0.39f, 0.39f, 1);
	        mc.renderEngine.bindTexture(this.slot);
			if(item != null && sold != null){
		        RenderHelper.enableGUIStandardItemLighting();
		        GL11.glColor4f(1, 1, 1, 1);
		        itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine, item, x + 13, y + 1);
		        renderItemOverlayIntoGUI(fontRendererObj, mc.renderEngine, item, x + 12, y + 1);
	            RenderHelper.disableStandardItemLighting(); 
	            fontRendererObj.drawString("=", x + 31, y + 5, 16777215);
			}
    	}
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        RenderHelper.enableStandardItemLighting();
        GL11.glPopMatrix();
    //	super.drawGuiContainerBackgroundLayer(paramFloat, paramInt1, paramInt2);
    }
    
    
    public void renderItemOverlayIntoGUI(FontRenderer p_77021_1_, TextureManager p_77021_2_, ItemStack p_77021_3_, int p_77021_4_, int p_77021_5_)
    {
        this.renderItemOverlayIntoGUI(p_77021_1_, p_77021_2_, p_77021_3_, p_77021_4_, p_77021_5_, (String)null);
    }

    public void renderItemOverlayIntoGUI(FontRenderer p_94148_1_, TextureManager p_94148_2_, ItemStack p_94148_3_, int p_94148_4_, int p_94148_5_, String p_94148_6_)
    {
        if (p_94148_3_ != null)
        {
                String s1 = String.valueOf(p_94148_3_.stackSize);
                GL11.glDisable(GL11.GL_LIGHTING);
                GL11.glDisable(GL11.GL_DEPTH_TEST);
                GL11.glDisable(GL11.GL_BLEND);
                p_94148_1_.drawStringWithShadow(s1, p_94148_4_ + 19 - 2 - p_94148_1_.getStringWidth(s1), p_94148_5_ + 6 + 3, 16777215);
                GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glEnable(GL11.GL_DEPTH_TEST);

            if (p_94148_3_.getItem().showDurabilityBar(p_94148_3_))
            {
                
                double health = p_94148_3_.getItem().getDurabilityForDisplay(p_94148_3_);
                int j1 = (int)Math.round(13.0D - health * 13.0D);
                int k = (int)Math.round(255.0D - health * 255.0D);
                GL11.glDisable(GL11.GL_LIGHTING);
                GL11.glDisable(GL11.GL_DEPTH_TEST);
                GL11.glDisable(GL11.GL_TEXTURE_2D);
                GL11.glDisable(GL11.GL_ALPHA_TEST);
                GL11.glDisable(GL11.GL_BLEND);
                Tessellator tessellator = Tessellator.instance;
                int l = 255 - k << 16 | k << 8;
                int i1 = (255 - k) / 4 << 16 | 16128;
                this.renderQuad(tessellator, p_94148_4_ + 2, p_94148_5_ + 13, 13, 2, 0);
                this.renderQuad(tessellator, p_94148_4_ + 2, p_94148_5_ + 13, 12, 1, i1);
                this.renderQuad(tessellator, p_94148_4_ + 2, p_94148_5_ + 13, j1, 1, l);
                //GL11.glEnable(GL11.GL_BLEND); // Forge: Disable Bled because it screws with a lot of things down the line.
                GL11.glEnable(GL11.GL_ALPHA_TEST);
                GL11.glEnable(GL11.GL_TEXTURE_2D);
                GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glEnable(GL11.GL_DEPTH_TEST);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            }
        }
    }
    
    private void renderQuad(Tessellator p_77017_1_, int p_77017_2_, int p_77017_3_, int p_77017_4_, int p_77017_5_, int p_77017_6_)
    {
        p_77017_1_.startDrawingQuads();
        p_77017_1_.setColorOpaque_I(p_77017_6_);
        p_77017_1_.addVertex((double)(p_77017_2_ + 0), (double)(p_77017_3_ + 0), 0.0D);
        p_77017_1_.addVertex((double)(p_77017_2_ + 0), (double)(p_77017_3_ + p_77017_5_), 0.0D);
        p_77017_1_.addVertex((double)(p_77017_2_ + p_77017_4_), (double)(p_77017_3_ + p_77017_5_), 0.0D);
        p_77017_1_.addVertex((double)(p_77017_2_ + p_77017_4_), (double)(p_77017_3_ + 0), 0.0D);
        p_77017_1_.draw();
    }

    
    
	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		drawCenteredString(fontRendererObj, this.title, xSize / 2, 4, 16777215);
		drawCenteredString(fontRendererObj, pageNumber + "/" + role.pageCount, this.xSize / 2, 147, 16777215);
	    drawCenteredString(fontRendererObj, "или", 60, 18, 16777215);
	    drawCenteredString(fontRendererObj, "или", 116, 18, 16777215);
//		for(int slot = 0; slot < 24; slot++){
//			int x = slot%3 * 72 + 10;
//			int y = slot/3 * 21 + 6;
//			
//			ItemStack item = role.inventoryCurrency.items.get(slot);
//			ItemStack item2 = role.inventoryCurrency.items.get(slot + 24);
//			if(item == null){
//				item = item2;
//				item2 = null;
//			}
//			if(NoppesUtilPlayer.compareItems(item, item2, role.ignoreDamage, role.ignoreNBT)){
//				item = item.copy();
//				item.stackSize += item2.stackSize;
//				item2 = null;
//			}
//			ItemStack sold = role.inventorySold.items.get(slot);
//			if(item == null || sold == null)
//				continue;
//
//			if(this.func_146978_c(x + 43, y + 1, 16, 16, par1, par2)){
//				if(!container.canBuy(slot, player)){
//		        	GL11.glTranslatef(0, 0, 300);
//					if(item != null && !NoppesUtilPlayer.compareItems(player, item, role.ignoreDamage, role.ignoreNBT))
//					
//					if(item2 != null && !NoppesUtilPlayer.compareItems(player, item2, role.ignoreDamage, role.ignoreNBT))
//						this.drawGradientRect(x - 1, y, x + 17, y + 18, 0x70771010, 0x70771010);
//					
//		        		String title = StatCollector.translateToLocal("trader.insufficient");
//						this.fontRendererObj.drawString(title, (xSize - fontRendererObj.getStringWidth(title))/2, 230, 0xDD0000);
//		        	GL11.glTranslatef(0, 0, -300);
//				}
//				else{
//		        	String title = StatCollector.translateToLocal("trader.sufficient");
//					this.fontRendererObj.drawString(title, (xSize - fontRendererObj.getStringWidth(title))/2, 230, 0x00DD00);
//				}
//			}
//
//            if (this.func_146978_c(x, y, 16, 16, par1, par2) && item2 != null){
//                this.renderToolTip(item2, par1 - guiLeft, par2 - guiTop);
//            }
//            if (this.func_146978_c(x + 18, y, 16, 16, par1, par2)){
//                this.renderToolTip(item, par1 - guiLeft, par2 - guiTop);
//            }
//    	}
    }
    
	@Override
	public void save() {
	}
}

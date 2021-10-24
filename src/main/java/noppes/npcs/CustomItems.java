package noppes.npcs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFlintAndSteel;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import noppes.npcs.blocks.BlockBanner;
import noppes.npcs.blocks.BlockBarrel;
import noppes.npcs.blocks.BlockBeam;
import noppes.npcs.blocks.BlockBigSign;
import noppes.npcs.blocks.BlockBlood;
import noppes.npcs.blocks.BlockBook;
import noppes.npcs.blocks.BlockBorder;
import noppes.npcs.blocks.BlockCampfire;
import noppes.npcs.blocks.BlockCandle;
import noppes.npcs.blocks.BlockCarpentryBench;
import noppes.npcs.blocks.BlockChair;
import noppes.npcs.blocks.BlockCouchWood;
import noppes.npcs.blocks.BlockCouchWool;
import noppes.npcs.blocks.BlockCrate;
import noppes.npcs.blocks.BlockCrystal;
import noppes.npcs.blocks.BlockLamp;
import noppes.npcs.blocks.BlockMailbox;
import noppes.npcs.blocks.BlockNpcRedstone;
import noppes.npcs.blocks.BlockPedestal;
import noppes.npcs.blocks.BlockPlaceholder;
import noppes.npcs.blocks.BlockShelf;
import noppes.npcs.blocks.BlockSign;
import noppes.npcs.blocks.BlockStool;
import noppes.npcs.blocks.BlockTable;
import noppes.npcs.blocks.BlockTallLamp;
import noppes.npcs.blocks.BlockTombstone;
import noppes.npcs.blocks.BlockWallBanner;
import noppes.npcs.blocks.BlockWaypoint;
import noppes.npcs.blocks.BlockWeaponRack;
import noppes.npcs.blocks.tiles.TileBanner;
import noppes.npcs.blocks.tiles.TileBarrel;
import noppes.npcs.blocks.tiles.TileBeam;
import noppes.npcs.blocks.tiles.TileBigSign;
import noppes.npcs.blocks.tiles.TileBlockAnvil;
import noppes.npcs.blocks.tiles.TileBook;
import noppes.npcs.blocks.tiles.TileBorder;
import noppes.npcs.blocks.tiles.TileCampfire;
import noppes.npcs.blocks.tiles.TileCandle;
import noppes.npcs.blocks.tiles.TileChair;
import noppes.npcs.blocks.tiles.TileCouchWood;
import noppes.npcs.blocks.tiles.TileCouchWool;
import noppes.npcs.blocks.tiles.TileCrate;
import noppes.npcs.blocks.tiles.TileLamp;
import noppes.npcs.blocks.tiles.TileMailbox;
import noppes.npcs.blocks.tiles.TilePedestal;
import noppes.npcs.blocks.tiles.TileRedstoneBlock;
import noppes.npcs.blocks.tiles.TileShelf;
import noppes.npcs.blocks.tiles.TileSign;
import noppes.npcs.blocks.tiles.TileStool;
import noppes.npcs.blocks.tiles.TileTable;
import noppes.npcs.blocks.tiles.TileTallLamp;
import noppes.npcs.blocks.tiles.TileTombstone;
import noppes.npcs.blocks.tiles.TileWallBanner;
import noppes.npcs.blocks.tiles.TileWaypoint;
import noppes.npcs.blocks.tiles.TileWeaponRack;
import noppes.npcs.constants.EnumNpcToolMaterial;

import noppes.npcs.items.ItemMounter;
import noppes.npcs.items.ItemMusic;
import noppes.npcs.items.ItemMusicBanjo;
import noppes.npcs.items.ItemMusicClarinet;
import noppes.npcs.items.ItemMusicOracina;
import noppes.npcs.items.ItemMusicViolin;
import noppes.npcs.items.ItemNpcArmor;
import noppes.npcs.items.ItemNpcArmorColorable;
import noppes.npcs.items.ItemNpcBlock;
import noppes.npcs.items.ItemNpcCloner;
import noppes.npcs.items.ItemNpcColored;
import noppes.npcs.items.ItemNpcInterface;
import noppes.npcs.items.ItemNpcMovingPath;
import noppes.npcs.items.ItemNpcScripter;
import noppes.npcs.items.ItemNpcWand;
import noppes.npcs.items.ItemNpcWeaponInterface;
import noppes.npcs.items.ItemPlaceholder;
import noppes.npcs.items.ItemTeleporter;
import noppes.npcs.items.ItemWand;
import cpw.mods.fml.common.registry.GameRegistry;

public class CustomItems {

	public static Item wand;
	public static Item cloner;
	public static Item scripter;
	public static Item moving;	
	public static Item mount;	
	public static Item teleporter;	

	
	public static Item banjo;
	public static Item violin;
	public static Item violinbow;
	public static Item harp;
	public static Item guitar;
	public static Item frenchHorn;
	public static Item clarinet;
	public static Item ocarina;

	public static Item coinWood;
	public static Item coinStone;
	public static Item coinIron;
	public static Item coinGold;
	public static Item coinDiamond;
	public static Item coinBronze;
	public static Item coinEmerald;
	public static Item moneyBag;

	public static Item bulletWood;
	public static Item bulletStone;
	public static Item bulletIron;
	public static Item bulletGold;
	public static Item bulletDiamond;
	public static Item bulletBronze;
	public static Item bulletEmerald;
	public static Item bulletBlack;

	public static Item gunWood;
	public static Item gunStone;
	public static Item gunIron;
	public static Item gunGold;
	public static Item gunDiamond;
	public static Item gunBronze;
	public static Item gunEmerald;
	public static Item gunMachine;

	public static Item halberdWood;
	public static Item halberdStone;
	public static Item halberdIron;
	public static Item halberdGold;
	public static Item halberdDiamond;
	public static Item halberdBronze;
	public static Item halberdEmerald;
	public static Item halberdDemonic;
	public static Item halberdFrost;
	public static Item halberdMithril;

	public static Item tridentWood;
	public static Item tridentStone;
	public static Item tridentIron;
	public static Item tridentGold;
	public static Item tridentDiamond;
	public static Item tridentBronze;
	public static Item tridentEmerald;
	public static Item tridentCurse;
	public static Item tridentDemonic;
	public static Item tridentFrost;
	public static Item tridentMithril;

	public static Item glaiveWood;
	public static Item glaiveStone;
	public static Item glaiveIron;
	public static Item glaiveGold;
	public static Item glaiveDiamond;
	public static Item glaiveBronze;
	public static Item glaiveEmerald;
	public static Item glaiveDemonic;
	public static Item glaiveFrost;
	public static Item glaiveMithril;

	public static Item battleAxeWood;
	public static Item battleAxeStone;
	public static Item battleAxeIron;
	public static Item battleAxeGold;
	public static Item battleAxeDiamond;
	public static Item battleAxeBronze;
	public static Item battleAxeEmerald;
	public static Item battleAxeCurse;
	public static Item battleAxeDemonic;
	public static Item battleAxeFrost;
	public static Item battleAxeMithril;

	public static Item spellNature;
	public static Item spellArcane;
	public static Item spellItem;
	public static Item spellLightning;
	public static Item spellIce;
	public static Item spellFire;
	public static Item spellDark;
	public static Item spellHoly;

	public static Item staffWood;
	public static Item staffStone;
	public static Item staffIron;
	public static Item staffGold;
	public static Item staffDiamond;
	public static Item staffBronze;
	public static Item staffEmerald;
	public static Item staffDemonic;
	public static Item staffFrost;
	public static Item staffMithril;
	public static Item staffElemental;
	public static Item orb;
	public static Item mana;
	
	public static Item swordBronze;
	public static Item swordEmerald;
	public static Item swordDemonic;
	public static Item swordFrost;
	public static Item swordMithril;
	
	public static Item bronze_ingot;
	public static Item demonic_ingot;
	public static Item mithril_ingot;

	public static Item kunai;
	public static Item shuriken;

	public static Item excalibur;
	public static Item letter;
	public static Item bag;
	public static Item satchel;
	
	public static Block redstoneBlock;
	public static Block carpentyBench;
	public static Block mailbox;
	public static Block waypoint;
	public static Block border;
	
	public static Block banner;
	public static Block wallBanner;
	public static Block tallLamp;
	public static Block blood;
	public static Block book;
	public static Block chair;
	public static Block crate;
	public static Block weaponsRack;
	public static Block pedestal;
	public static Block couchWool;
	public static Block couchWood;
	public static Block table;
	public static Block stool;
	public static Block bigsign;
	public static Block barrel;
	public static Block tombstone;
	public static Block shelf;
	public static Block sign;
	public static Block beam;
	public static Block crystal;

	public static Block lamp;
	public static Block campfire;
	public static Block candle;

	public static Block lamp_unlit;
	public static Block campfire_unlit;
	public static Block candle_unlit;
	
	public static Item crossbowBolt;

	public static CreativeTabNpcs tab = new CreativeTabNpcs("cnpcs");
	public static CreativeTabNpcs tabArmor;
	public static CreativeTabNpcs tabWeapon;
	public static CreativeTabNpcs tabBlocks = new CreativeTabNpcs("cnpcsb");
	public static CreativeTabNpcs tabMisc = new CreativeTabNpcs("cnpcsm");
	
	
	public static void load(){		
		GameRegistry.registerTileEntity(TileRedstoneBlock.class, "TileRedstoneBlock");
		GameRegistry.registerTileEntity(TileBlockAnvil.class, "TileBlockAnvil");
		GameRegistry.registerTileEntity(TileMailbox.class, "TileMailbox");
		GameRegistry.registerTileEntity(TileWaypoint.class, "TileWaypoint");
		GameRegistry.registerTileEntity(TileBanner.class, "TileNPCBanner");
		
		if(!CustomNpcs.DisableExtraBlock){
			GameRegistry.registerTileEntity(TileWallBanner.class, "TileNPCWallBanner");
			GameRegistry.registerTileEntity(TileTallLamp.class, "TileNPCTallLamp");
			GameRegistry.registerTileEntity(TileChair.class, "TileNPCChair");
			GameRegistry.registerTileEntity(TileCrate.class, "TileNPCCrate");
			GameRegistry.registerTileEntity(TileWeaponRack.class, "TileNPCWeaponRack");
			GameRegistry.registerTileEntity(TileCouchWool.class, "TileNPCCouchWool");
			GameRegistry.registerTileEntity(TileCouchWood.class, "TileNPCCouchWood");
			GameRegistry.registerTileEntity(TileTable.class, "TileNPCTable");
			GameRegistry.registerTileEntity(TileLamp.class, "TileNPCLamp");
			GameRegistry.registerTileEntity(TileCandle.class, "TileNPCCandle");
			GameRegistry.registerTileEntity(TileBorder.class, "TileNPCBorder");
			GameRegistry.registerTileEntity(TileStool.class, "TileNPCStool");
			GameRegistry.registerTileEntity(TileBigSign.class, "TileNPCBigSign");
			GameRegistry.registerTileEntity(TileBarrel.class, "TileNPCBarrel");
			GameRegistry.registerTileEntity(TileCampfire.class, "TileNPCCampfire");
			GameRegistry.registerTileEntity(TileTombstone.class, "TileNPCTombstone");
			GameRegistry.registerTileEntity(TileShelf.class, "TileNPCShelf");
			GameRegistry.registerTileEntity(TileSign.class, "TileNPCSign");
			GameRegistry.registerTileEntity(TileBeam.class, "TileNPCBeam");
			GameRegistry.registerTileEntity(TileBook.class, "TileNPCBook");
			GameRegistry.registerTileEntity(TilePedestal.class, "TileNPCPedestal");
		}
		wand = new ItemNpcWand().setUnlocalizedName("npcWand").setFull3D();
		cloner = new ItemNpcCloner().setUnlocalizedName("npcMobCloner").setFull3D();
		scripter = new ItemNpcScripter().setUnlocalizedName("npcScripter").setFull3D();
		moving = new ItemNpcMovingPath().setUnlocalizedName("npcMovingPath").setFull3D();
		mount = new ItemMounter().setUnlocalizedName("npcMounter").setFull3D();
		teleporter = new ItemTeleporter().setUnlocalizedName("npcTeleporter").setFull3D();
		
		redstoneBlock = new BlockNpcRedstone().setHardness(50.0F).setResistance(2000).setBlockName("npcRedstoneBlock").setBlockTextureName("customnpcs:npcRedstoneBlock").setCreativeTab(tab);
		carpentyBench = new BlockCarpentryBench().setBlockName("npcCarpentyBench").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
		mailbox = new BlockMailbox().setBlockName("npcMailbox").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setCreativeTab(tabBlocks);
		waypoint = new BlockWaypoint().setBlockName("npcLocationBlock").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setBlockTextureName("customnpcs:npcWaypoint").setCreativeTab(tab);
		border = new BlockBorder().setBlockName("npcBorder").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tab).setBlockTextureName("customnpcs:npcBorder");
		GameRegistry.registerBlock(redstoneBlock, "npcRedstoneBlock");
		GameRegistry.registerBlock(carpentyBench, ItemNpcBlock.class, "npcCarpentyBench");
		GameRegistry.registerBlock(mailbox, ItemBlock.class, "npcMailbox");
		GameRegistry.registerBlock(waypoint, "npcWaypoint");
		GameRegistry.registerBlock(border, "npcBorder");

		Item.getItemFromBlock(mailbox).setHasSubtypes(true);
		Item.getItemFromBlock(carpentyBench).setHasSubtypes(true);
		
		((ItemNpcBlock)Item.getItemFromBlock(carpentyBench)).names = new String[]{"tile.npcCarpentyBench", "tile.anvil"};
		
		if(!CustomNpcs.DisableExtraBlock){
			blood = new BlockBlood().setBlockName("npcBloodBlock").setBlockTextureName("customnpcs:npcBloodBlock").setCreativeTab(tabBlocks);
			banner = new BlockBanner().setBlockName("npcBanner").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setCreativeTab(tabBlocks);
			wallBanner = new BlockWallBanner().setBlockName("npcWallBanner").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setCreativeTab(tabBlocks);
			tallLamp = new BlockTallLamp().setBlockName("npcTallLamp").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setCreativeTab(tabBlocks);
			chair = new BlockChair().setBlockName("npcChair").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
			crate = new BlockCrate().setBlockName("npcCrate").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
			weaponsRack = new BlockWeaponRack().setBlockName("npcWeaponRack").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
			couchWool = new BlockCouchWool().setBlockName("npcCouchWool").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
			table = new BlockTable().setBlockName("npcTable").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
			couchWood = new BlockCouchWood().setBlockName("npcCouchWood").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
			lamp = new BlockLamp(true).setBlockName("npcLamp").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
			candle = new BlockCandle(true).setBlockName("npcCandle").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
			stool = new BlockStool().setBlockName("npcStool").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
			Block placeholder = new BlockPlaceholder().setBlockName("npcPlaceholder").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabMisc);
			bigsign = new BlockBigSign().setBlockName("npcBigSign").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
			barrel = new BlockBarrel().setBlockName("npcBarrel").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
			campfire = new BlockCampfire(true).setBlockName("npcCampfire").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setCreativeTab(tabBlocks);
			tombstone = new BlockTombstone().setBlockName("npcTombstone").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setCreativeTab(tabBlocks);
			shelf = new BlockShelf().setBlockName("npcShelf").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
			sign = new BlockSign().setBlockName("npcSign").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
			beam = new BlockBeam().setBlockName("npcBeam").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
			book = new BlockBook().setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
			pedestal = new BlockPedestal().setBlockName("npcPedestal").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood).setCreativeTab(tabBlocks);
			crystal = new BlockCrystal().setBlockName("npcCrystal").setBlockTextureName("customnpcs:npcCrystal").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeGlass).setCreativeTab(tabBlocks);
	
			campfire_unlit = new BlockCampfire(false).setBlockName("npcCampfire").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeStone);
			lamp_unlit = new BlockLamp(false).setBlockName("npcLamp").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood);
			candle_unlit = new BlockCandle(false).setBlockName("npcCandle").setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeWood);

			GameRegistry.registerBlock(blood, "npcBloodBlock");
			GameRegistry.registerBlock(banner, ItemBlock.class, "npcBanner");
			GameRegistry.registerBlock(wallBanner, ItemBlock.class, "npcWallBanner");
			GameRegistry.registerBlock(tallLamp, ItemBlock.class, "npcTallLamp");
			GameRegistry.registerBlock(chair, ItemBlock.class, "npcChair");
			GameRegistry.registerBlock(crate, ItemBlock.class, "npcCrate");	
			GameRegistry.registerBlock(weaponsRack, ItemBlock.class, "npcWeaponRack");	
			GameRegistry.registerBlock(couchWool, ItemBlock.class, "npcCouchWool");	
			GameRegistry.registerBlock(couchWood, ItemBlock.class, "npcCouchWood");	
			GameRegistry.registerBlock(table, ItemBlock.class, "npcTable");	
			GameRegistry.registerBlock(stool, ItemBlock.class, "npcStool");	
			GameRegistry.registerBlock(placeholder, ItemPlaceholder.class, "npcPlaceholder");	
			GameRegistry.registerBlock(bigsign, "npcBigSign");
			GameRegistry.registerBlock(barrel, ItemBlock.class, "npcBarrel");	
			GameRegistry.registerBlock(tombstone, ItemBlock.class, "npcTombstone");	
			GameRegistry.registerBlock(shelf, ItemBlock.class, "npcShelf");	
			GameRegistry.registerBlock(sign, ItemBlock.class, "npcSign");
			GameRegistry.registerBlock(beam, ItemBlock.class, "npcBeam");
			GameRegistry.registerBlock(book, "npcBook");
			GameRegistry.registerBlock(pedestal, ItemBlock.class, "npcPedestal");
			GameRegistry.registerBlock(crystal, ItemNpcColored.class, "npcCrystalBlock");
			GameRegistry.registerBlock(campfire, "npcCampfire");
			GameRegistry.registerBlock(lamp, "npcLamp");
			GameRegistry.registerBlock(candle, "npcCandle");
			GameRegistry.registerBlock(campfire_unlit, "npcCampfireUnlit");
			GameRegistry.registerBlock(candle_unlit, "npcLampUnlit");
			GameRegistry.registerBlock(lamp_unlit, "npcCandleUnlit");

			Item.getItemFromBlock(banner).setHasSubtypes(true);
			Item.getItemFromBlock(wallBanner).setHasSubtypes(true);
			Item.getItemFromBlock(tallLamp).setHasSubtypes(true);
			Item.getItemFromBlock(chair).setHasSubtypes(true);
			Item.getItemFromBlock(crate).setHasSubtypes(true);
			Item.getItemFromBlock(weaponsRack).setHasSubtypes(true);
			Item.getItemFromBlock(couchWool).setHasSubtypes(true);
			Item.getItemFromBlock(couchWood).setHasSubtypes(true);
			Item.getItemFromBlock(table).setHasSubtypes(true);
			Item.getItemFromBlock(stool).setHasSubtypes(true);
			Item.getItemFromBlock(barrel).setHasSubtypes(true);
			Item.getItemFromBlock(tombstone).setHasSubtypes(true);
			Item.getItemFromBlock(shelf).setHasSubtypes(true);
			Item.getItemFromBlock(sign).setHasSubtypes(true);
			Item.getItemFromBlock(beam).setHasSubtypes(true);
			Item.getItemFromBlock(pedestal).setHasSubtypes(true);
		}

		banjo = new ItemMusicBanjo().setUnlocalizedName("npcBanjo").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcBanjo");
		violin = new ItemMusicViolin().setUnlocalizedName("npcViolin").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcViolin");	
		violinbow = new ItemNpcInterface().setUnlocalizedName("npcViolinBow").setFull3D().setMaxStackSize(1).setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcViolinBow");
		harp = new ItemMusicViolin().setUnlocalizedName("npcHarp").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcHarp");
		guitar = new ItemMusicBanjo().setUnlocalizedName("npcGuitar").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcGuitar");
		frenchHorn = new ItemMusic().setRotated().setUnlocalizedName("npcFrenchHorn").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcFrenchHorn");
		ocarina = new ItemMusicOracina().setUnlocalizedName("npcOcarina").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcOcarina");
		clarinet = new ItemMusicClarinet().setUnlocalizedName("npcClarinet").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcClarinet");
		
		
		if(!CustomNpcs.DisableExtraItems){
			tabArmor = new CreativeTabNpcs("cnpcsa");
			tabWeapon = new CreativeTabNpcs("cnpcsw");
	
			ToolMaterial bronze = EnumHelper.addToolMaterial("BRONZE", 2, 170, 5.0F, 2, 15);
			ToolMaterial emerald = EnumHelper.addToolMaterial("REALEMERALD", 3, 1000, 8.0F, 4, 10);
			ToolMaterial demonic = EnumHelper.addToolMaterial("DEMONIC", 3, 100, 8.0F, 6, 22);
			ToolMaterial frost = EnumHelper.addToolMaterial("FROST", 2, 59, 6.0F, 3, 5);
			ToolMaterial mithril = EnumHelper.addToolMaterial("MITHRIL", 3, 3000, 8.0F, 3.0F, 10);
			

			spellNature = new ItemNpcInterface(26930).setUnlocalizedName("npcNatureSpell").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcNatureSpell");
			spellArcane = new ItemNpcInterface(26931).setUnlocalizedName("npcArcaneSpell").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcArcaneSpell");
			spellLightning = new ItemNpcInterface(26932).setUnlocalizedName("npcLightningSpell").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcLightningSpell");
			spellIce = new ItemNpcInterface(26933).setUnlocalizedName("npcIceSpell").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcIceSpell");
			spellFire = new ItemNpcInterface(26934).setUnlocalizedName("npcFireSpell").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcFireSpell");
			spellDark = new ItemNpcInterface(26935).setUnlocalizedName("npcDarkSpell").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcDarkSpell");
			spellHoly = new ItemNpcInterface(26936).setUnlocalizedName("npcHolySpell").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcHolySpell");
	
			mana = new ItemNpcInterface(26938).setUnlocalizedName("npcMana").setCreativeTab(CustomItems.tabWeapon).setTextureName("customnpcs:npcMana");
			Item katana = new ItemNpcWeaponInterface(26914,ToolMaterial.IRON).setUnlocalizedName("npcKatana").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcKatana");

			swordBronze = new ItemNpcWeaponInterface(bronze).setUnlocalizedName("npcBronzeSword").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcBronzeSword");
			swordEmerald = new ItemNpcWeaponInterface(emerald).setUnlocalizedName("npcEmeraldSword").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcEmeraldSword");
			swordDemonic = new ItemNpcWeaponInterface(demonic).setUnlocalizedName("npcDemonicSword").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcDemonicSword");
			swordFrost = new ItemNpcWeaponInterface(frost).setUnlocalizedName("npcFrostSword").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcFrostSword");
			swordMithril = new ItemNpcWeaponInterface(mithril).setUnlocalizedName("npcMithrilSword").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcMithrilSword");
			
			Item magicwand = new ItemWand(26801).setUnlocalizedName("npcMagicWand").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcMagicWand");
			Item chickenSword = new ItemNpcInterface(26802).setUnlocalizedName("npcChickenSword").setFull3D().setMaxStackSize(1).setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcChickenSword");
			Item handcuffs = new ItemNpcInterface(26803).setUnlocalizedName("npcHandCuffs").setFull3D().setMaxStackSize(1).setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcHandCuffs");
			Item hammer = new ItemNpcWeaponInterface(26804,ToolMaterial.STONE).setUnlocalizedName("npcHammer").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcHammer");
			Item baseballbat = new ItemNpcWeaponInterface(26805,ToolMaterial.IRON).setUnlocalizedName("npcBaseballBat").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcBaseballBat");
			Item leadpipe = new ItemNpcWeaponInterface(26806,ToolMaterial.IRON).setUnlocalizedName("npcLeadPipe").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcLeadPipe");
			Item cleaver = new ItemNpcWeaponInterface(26807,ToolMaterial.IRON).setUnlocalizedName("npcCleaver").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcCleaver");
			Item saber = new ItemNpcWeaponInterface(26808,ToolMaterial.IRON).setUnlocalizedName("npcSaber").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcSaber");
		Item bottle = new ItemNpcWeaponInterface(26811,ToolMaterial.IRON).setUnlocalizedName("npcBrokenBottle").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcBrokenBottle");

			Item batton = new ItemNpcWeaponInterface(26814,ToolMaterial.STONE).setUnlocalizedName("npcBatton").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcBatton");
			Item rapier = new ItemNpcWeaponInterface(26816,ToolMaterial.IRON).setUnlocalizedName("npcRapier").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcRapier");
			Item crowbar = new ItemNpcWeaponInterface(26817,ToolMaterial.IRON).setUnlocalizedName("npcCrowbar").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcCrowbar");
			Item pipewrench = new ItemNpcWeaponInterface(26818,ToolMaterial.IRON).setUnlocalizedName("npcPipeWrench").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcPipeWrench");
			Item wrench = new ItemNpcWeaponInterface(26836,ToolMaterial.IRON).setUnlocalizedName("npcWrench").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcWrench");		

			Item mace = new ItemNpcWeaponInterface(26770,ToolMaterial.WOOD).setUnlocalizedName("npcWoodenMace").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcWoodenMace");
			mace = new ItemNpcWeaponInterface(26771,ToolMaterial.STONE).setUnlocalizedName("npcStoneMace").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcStoneMace");
			mace = new ItemNpcWeaponInterface(26772,ToolMaterial.IRON).setUnlocalizedName("npcIronMace").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcIronMace");
			mace = new ItemNpcWeaponInterface(26773,ToolMaterial.GOLD).setUnlocalizedName("npcGoldenMace").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcGoldenMace");
			mace = new ItemNpcWeaponInterface(26774,ToolMaterial.EMERALD).setUnlocalizedName("npcDiamondMace").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcDiamondMace");
			mace = new ItemNpcWeaponInterface(26775,bronze).setUnlocalizedName("npcBronzeMace").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcBronzeMace");
			mace = new ItemNpcWeaponInterface(26776,emerald).setUnlocalizedName("npcEmeraldMace").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcEmeraldMace");
			mace = new ItemNpcWeaponInterface(26776,demonic).setUnlocalizedName("npcDemonicMace").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcDemonicMace");
			mace = new ItemNpcWeaponInterface(26776,frost).setUnlocalizedName("npcFrostMace").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcFrostMace");
			mace = new ItemNpcWeaponInterface(26776,mithril).setUnlocalizedName("npcMithrilMace").setFull3D().setMaxStackSize(1).setTextureName("customnpcs:npcMithrilMace");
			

			ItemArmor.ArmorMaterial armorMithril = EnumHelper.addArmorMaterial("MITHRIL", 40, new int[]{3, 8, 6, 3}, 20);
			ItemArmor.ArmorMaterial armorBronze = EnumHelper.addArmorMaterial("BRONZE", 7, new int[]{2, 6, 5, 2}, 20);
			ItemArmor.ArmorMaterial armorEmerald = EnumHelper.addArmorMaterial("EMERALD", 35, new int[]{5, 7, 4, 5}, 5);
			
			Item cowarmor = new ItemNpcArmor(26860, ArmorMaterial.CHAIN,0,"cowleather").setUnlocalizedName("npcCowleatherHead").setMaxStackSize(1).setTextureName("customnpcs:npcCowleatherHead");
			Item armor = new ItemNpcArmor(26861,ArmorMaterial.CHAIN,1,"cowleather").setUnlocalizedName("npcCowleatherChest").setMaxStackSize(1).setTextureName("customnpcs:npcCowleatherChest");
			armor = new ItemNpcArmor(26862,ArmorMaterial.CHAIN,2,"cowleather").setUnlocalizedName("npcCowleatherLegs").setMaxStackSize(1).setTextureName("customnpcs:npcCowleatherLegs");
			armor = new ItemNpcArmor(26863,ArmorMaterial.CHAIN,3,"cowleather").setUnlocalizedName("npcCowleatherBoots").setMaxStackSize(1).setTextureName("customnpcs:npcCowleatherBoots");
	
			armor = new ItemNpcArmor(26864,ArmorMaterial.IRON,0,"nanorum").setUnlocalizedName("npcNanorumHead").setMaxStackSize(1).setTextureName("customnpcs:npcNanorumHead");
			armor = new ItemNpcArmor(26865,ArmorMaterial.IRON,1,"nanorum").setUnlocalizedName("npcNanorumChest").setMaxStackSize(1).setTextureName("customnpcs:npcNanorumChest");
			armor = new ItemNpcArmor(26866,ArmorMaterial.IRON,2,"nanorum").setUnlocalizedName("npcNanorumLegs").setMaxStackSize(1).setTextureName("customnpcs:npcNanorumLegs");
			armor = new ItemNpcArmor(26867,ArmorMaterial.IRON,3,"nanorum").setUnlocalizedName("npcNanorumBoots").setMaxStackSize(1).setTextureName("customnpcs:npcNanorumBoots");
			
			armor = new ItemNpcArmor(26868,ArmorMaterial.IRON,0,"tactical").setUnlocalizedName("npcTacticalHead").setMaxStackSize(1).setTextureName("customnpcs:npcTacticalHead");
			armor = new ItemNpcArmor(26869,ArmorMaterial.IRON,1,"tactical").setUnlocalizedName("npcTacticalChest").setMaxStackSize(1).setTextureName("customnpcs:npcTacticalChest");
			
			armor = new ItemNpcArmor(26919,ArmorMaterial.IRON,0,"fullcloth").setUnlocalizedName("npcFullLeatherHead").setMaxStackSize(1).setTextureName("customnpcs:npcFullLeatherHead");
			armor = new ItemNpcArmor(26920,ArmorMaterial.IRON,1,"fullcloth").setUnlocalizedName("npcFullLeatherChest").setMaxStackSize(1).setTextureName("customnpcs:npcFullLeatherChest");
			
			armor = new ItemNpcArmor(26870,ArmorMaterial.IRON,0,"fulliron").setUnlocalizedName("npcFullIronHead").setMaxStackSize(1).setTextureName("customnpcs:npcFullIronHead");
			armor = new ItemNpcArmor(26871,ArmorMaterial.IRON,1,"fulliron").setUnlocalizedName("npcFullIronChest").setMaxStackSize(1).setTextureName("customnpcs:npcFullIronChest");
			
			armor = new ItemNpcArmor(26872,ArmorMaterial.GOLD,0,"fullgold").setUnlocalizedName("npcFullGoldHead").setMaxStackSize(1).setTextureName("customnpcs:npcFullGoldHead");
			armor = new ItemNpcArmor(26873,ArmorMaterial.GOLD,1,"fullgold").setUnlocalizedName("npcFullGoldChest").setMaxStackSize(1).setTextureName("customnpcs:npcFullGoldChest");
			
			armor = new ItemNpcArmor(26874,ArmorMaterial.DIAMOND,0,"fulldiamond").setUnlocalizedName("npcFullDiamondHead").setMaxStackSize(1).setTextureName("customnpcs:npcFullDiamondHead");
			armor = new ItemNpcArmor(26875,ArmorMaterial.DIAMOND,1,"fulldiamond").setUnlocalizedName("npcFullDiamondChest").setMaxStackSize(1).setTextureName("customnpcs:npcFullDiamondChest");
	
			armor = new ItemNpcArmor(26876, armorBronze,0,"fullbronze").setUnlocalizedName("npcFullBronzeHead").setMaxStackSize(1).setTextureName("customnpcs:npcFullBronzeHead");
			armor = new ItemNpcArmor(26877, armorBronze,1,"fullbronze").setUnlocalizedName("npcFullBronzeChest").setMaxStackSize(1).setTextureName("customnpcs:npcFullBronzeChest");
			armor = new ItemNpcArmor(26878, armorBronze,2,"fullbronze").setUnlocalizedName("npcFullBronzeLeggings").setMaxStackSize(1).setTextureName("customnpcs:npcFullBronzeLeggings");
			armor = new ItemNpcArmor(26879, armorBronze,3,"fullbronze").setUnlocalizedName("npcFullBronzeBoots").setMaxStackSize(1).setTextureName("customnpcs:npcFullBronzeBoots");
	
			armor = new ItemNpcArmor(26921, armorEmerald,0,"fullemerald").setUnlocalizedName("npcFullEmeraldHead").setMaxStackSize(1).setTextureName("customnpcs:npcFullEmeraldHead");
			armor = new ItemNpcArmor(26922, armorEmerald,1,"fullemerald").setUnlocalizedName("npcFullEmeraldChest").setMaxStackSize(1).setTextureName("customnpcs:npcFullEmeraldChest");
			armor = new ItemNpcArmor(26923, armorEmerald,2,"fullemerald").setUnlocalizedName("npcFullEmeraldLeggings").setMaxStackSize(1).setTextureName("customnpcs:npcFullEmeraldLeggings");
			armor = new ItemNpcArmor(26924, armorEmerald,3,"fullemerald").setUnlocalizedName("npcFullEmeraldBoots").setMaxStackSize(1).setTextureName("customnpcs:npcFullEmeraldBoots");
	
			armor = new ItemNpcArmor(26880,ArmorMaterial.CLOTH,0,"fullwood").setUnlocalizedName("npcFullWoodenHead").setMaxStackSize(1).setTextureName("customnpcs:npcFullWoodenHead");
			armor = new ItemNpcArmor(26881,ArmorMaterial.CLOTH,1,"fullwood").setUnlocalizedName("npcFullWoodenChest").setMaxStackSize(1).setTextureName("customnpcs:npcFullWoodenChest");
			armor = new ItemNpcArmor(26882,ArmorMaterial.CLOTH,2,"fullwood").setUnlocalizedName("npcFullWoodenLeggings").setMaxStackSize(1).setTextureName("customnpcs:npcFullWoodenLeggings");
			armor = new ItemNpcArmor(26883,ArmorMaterial.CLOTH,3,"fullwood").setUnlocalizedName("npcFullWoodenBoots").setMaxStackSize(1).setTextureName("customnpcs:npcFullWoodenBoots");
	
			armor = new ItemNpcArmor(26884,ArmorMaterial.CHAIN,1,"tuxido").setUnlocalizedName("npcTuxedoChest").setMaxStackSize(1).setTextureName("customnpcs:npcTuxedoChest");
			armor = new ItemNpcArmor(26885,ArmorMaterial.CHAIN,2,"tuxido").setUnlocalizedName("npcTuxedoPants").setMaxStackSize(1).setTextureName("customnpcs:npcTuxedoPants");
			armor = new ItemNpcArmor(26886,ArmorMaterial.CHAIN,3,"tuxido").setUnlocalizedName("npcTuxedoBottom").setMaxStackSize(1).setTextureName("customnpcs:npcTuxedoBottom");
	
			armor = new ItemNpcArmor(26887,ArmorMaterial.CHAIN,0,"wizard").setUnlocalizedName("npcWizardHead").setMaxStackSize(1).setTextureName("customnpcs:npcWizardHead");
			armor = new ItemNpcArmor(26888,ArmorMaterial.CHAIN,1,"wizard").setUnlocalizedName("npcWizardChest").setMaxStackSize(1).setTextureName("customnpcs:npcWizardChest");
			armor = new ItemNpcArmor(26889,ArmorMaterial.CHAIN,2,"wizard").setUnlocalizedName("npcWizardPants").setMaxStackSize(1).setTextureName("customnpcs:npcWizardPants");
	
			armor = new ItemNpcArmor(26890,ArmorMaterial.IRON,0,"assassin").setUnlocalizedName("npcAssassinHead").setMaxStackSize(1).setTextureName("customnpcs:npcAssassinHead");
			armor = new ItemNpcArmor(26891,ArmorMaterial.IRON,1,"assassin").setUnlocalizedName("npcAssassinChest").setMaxStackSize(1).setTextureName("customnpcs:npcAssassinChest");
			armor = new ItemNpcArmor(26892,ArmorMaterial.IRON,2,"assassin").setUnlocalizedName("npcAssassinLeggings").setMaxStackSize(1).setTextureName("customnpcs:npcAssassinLeggings");
			armor = new ItemNpcArmor(26893,ArmorMaterial.IRON,3,"assassin").setUnlocalizedName("npcAssassinBoots").setMaxStackSize(1).setTextureName("customnpcs:npcAssassinBoots");
	
			armor = new ItemNpcArmor(26894,ArmorMaterial.IRON,0,"soldier").setUnlocalizedName("npcSoldierHead").setMaxStackSize(1).setTextureName("customnpcs:npcSoldierHead");
			armor = new ItemNpcArmor(26895,ArmorMaterial.IRON,1,"soldier").setUnlocalizedName("npcSoldierChest").setMaxStackSize(1).setTextureName("customnpcs:npcSoldierChest");
			armor = new ItemNpcArmor(26896,ArmorMaterial.IRON,2,"soldier").setUnlocalizedName("npcSoldierLegs").setMaxStackSize(1).setTextureName("customnpcs:npcSoldierLegs");
			armor = new ItemNpcArmor(26897,ArmorMaterial.IRON,3,"soldier").setUnlocalizedName("npcSoldierBottom").setMaxStackSize(1).setTextureName("customnpcs:npcSoldierBottom");

			armor = new ItemNpcArmor(26898,ArmorMaterial.DIAMOND,0,"x407").setUnlocalizedName("npcX407Head").setMaxStackSize(1).setTextureName("customnpcs:npcX407Head");
			armor = new ItemNpcArmor(26899,ArmorMaterial.DIAMOND,1,"x407").setUnlocalizedName("npcX407Chest").setMaxStackSize(1).setTextureName("customnpcs:npcX407Chest");
			armor = new ItemNpcArmor(26900,ArmorMaterial.DIAMOND,2,"x407").setUnlocalizedName("npcX407Legs").setMaxStackSize(1).setTextureName("customnpcs:npcX407Legs");
			armor = new ItemNpcArmor(26901,ArmorMaterial.DIAMOND,3,"x407").setUnlocalizedName("npcX407Boots").setMaxStackSize(1).setTextureName("customnpcs:npcX407Boots");

			armor = new ItemNpcArmor(26898,armorMithril,0,"mithril").setUnlocalizedName("npcMithrilHead").setMaxStackSize(1).setTextureName("customnpcs:npcMithrilHead");
			armor = new ItemNpcArmor(26899,armorMithril,1,"mithril").setUnlocalizedName("npcMithrilChest").setMaxStackSize(1).setTextureName("customnpcs:npcMithrilChest");
			armor = new ItemNpcArmor(26900,armorMithril,2,"mithril").setUnlocalizedName("npcMithrilLegs").setMaxStackSize(1).setTextureName("customnpcs:npcMithrilLegs");
			armor = new ItemNpcArmor(26901,armorMithril,3,"mithril").setUnlocalizedName("npcMithrilBoots").setMaxStackSize(1).setTextureName("customnpcs:npcMithrilBoots");

			armor = new ItemNpcArmor(26898,ArmorMaterial.DIAMOND,0,"demonic").setUnlocalizedName("npcDemonicHead").setMaxStackSize(1).setTextureName("customnpcs:npcDemonicHead");
			armor = new ItemNpcArmor(26899,ArmorMaterial.DIAMOND,1,"demonic").setUnlocalizedName("npcDemonicChest").setMaxStackSize(1).setTextureName("customnpcs:npcDemonicChest");
			armor = new ItemNpcArmor(26900,ArmorMaterial.DIAMOND,2,"demonic").setUnlocalizedName("npcDemonicLegs").setMaxStackSize(1).setTextureName("customnpcs:npcDemonicLegs");
			armor = new ItemNpcArmor(26901,ArmorMaterial.DIAMOND,3,"demonic").setUnlocalizedName("npcDemonicBoots").setMaxStackSize(1).setTextureName("customnpcs:npcDemonicBoots");
	
			armor = new ItemNpcArmor(26902,ArmorMaterial.GOLD,0,"commissar").setUnlocalizedName("npcCommissarHead").setMaxStackSize(1).setTextureName("customnpcs:npcCommissarHead");
			armor = new ItemNpcArmor(26903,ArmorMaterial.GOLD,1,"commissar").setUnlocalizedName("npcCommissarChest").setMaxStackSize(1).setTextureName("customnpcs:npcCommissarChest");
			armor = new ItemNpcArmor(26904,ArmorMaterial.GOLD,2,"commissar").setUnlocalizedName("npcCommissarLegs").setMaxStackSize(1).setTextureName("customnpcs:npcCommissarLegs");
			armor = new ItemNpcArmor(26905,ArmorMaterial.GOLD,3,"commissar").setUnlocalizedName("npcCommissarBottom").setMaxStackSize(1).setTextureName("customnpcs:npcCommissarBottom");
	
			armor = new ItemNpcArmor(26906,ArmorMaterial.IRON,0,"infantry").setUnlocalizedName("npcInfantryHelmet").setMaxStackSize(1).setTextureName("customnpcs:npcInfantryHelmet");
			armor = new ItemNpcArmor(26907,ArmorMaterial.DIAMOND,1,"officer").setUnlocalizedName("npcOfficerChest").setMaxStackSize(1).setTextureName("customnpcs:npcOfficerChest");
	
			armor = new ItemNpcArmor(26908,ArmorMaterial.DIAMOND,0,"crown1").setUnlocalizedName("npcCrown2").setMaxStackSize(1).setTextureName("customnpcs:npcCrown2");
			armor = new ItemNpcArmor(26909,ArmorMaterial.DIAMOND,0,"crown2").setUnlocalizedName("npcCrown").setMaxStackSize(1).setTextureName("customnpcs:npcCrown");
			armor = new ItemNpcArmorColorable(26909,ArmorMaterial.CLOTH,0,"papercrown").setUnlocalizedName("npcPaperCrown").setMaxStackSize(1).setTextureName("customnpcs:npcPaperCrown");
	
			armor = new ItemNpcArmor(26916,ArmorMaterial.IRON,0,"ninja").setUnlocalizedName("npcNinjaHead").setMaxStackSize(1).setTextureName("customnpcs:npcNinjaHead");
			armor = new ItemNpcArmor(26917,ArmorMaterial.IRON,1,"ninja").setUnlocalizedName("npcNinjaChest").setMaxStackSize(1).setTextureName("customnpcs:npcNinjaChest");
			armor = new ItemNpcArmor(26918,ArmorMaterial.IRON,2,"ninja").setUnlocalizedName("npcNinjaPants").setMaxStackSize(1).setTextureName("customnpcs:npcNinjaPants");
	

			
			coinWood = new ItemNpcInterface(26717).setUnlocalizedName("npcCoinWooden").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcCoinWooden");
			coinStone = new ItemNpcInterface(26718).setUnlocalizedName("npcCoinStone").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcCoinStone");
			coinBronze = new ItemNpcInterface(26719).setUnlocalizedName("npcCoinBronze").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcCoinBronze");
			coinIron = new ItemNpcInterface(26720).setUnlocalizedName("npcCoinIron").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcCoinIron");
			coinGold = new ItemNpcInterface(26721).setUnlocalizedName("npcCoinGold").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcCoinGold");
			coinDiamond = new ItemNpcInterface(26722).setUnlocalizedName("npcCoinDiamond").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcCoinDiamond");
			coinEmerald = new ItemNpcInterface(26723).setUnlocalizedName("npcCoinEmerald").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcCoinEmerald");
			Item quest = new ItemNpcInterface().setUnlocalizedName("npcAncientCoin").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcAncientCoin");
			
			letter = new ItemNpcInterface(26950).setUnlocalizedName("npcLetter").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcLetter");
			quest = new ItemNpcInterface(26951).setUnlocalizedName("npcPlans").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcPlans");
			satchel = new ItemNpcInterface(26952).setUnlocalizedName("npcSatchel").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcSatchel");
			bag = new ItemNpcInterface(26953).setUnlocalizedName("npcBag").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcBag");
			
			quest = new ItemNpcInterface(26954).setUnlocalizedName("npcCrystal").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcCrystal");
			quest = new ItemNpcInterface(26955).setUnlocalizedName("npcSeveredEar").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcSeveredEar");
			quest = new ItemNpcInterface(26956).setUnlocalizedName("npcPhone").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcPhone");
	
			quest = new ItemNpcArmor(26957,ArmorMaterial.IRON,0,"mask").setMaxStackSize(64).setUnlocalizedName("npcBanditMask").setCreativeTab(CustomItems.tabArmor).setTextureName("customnpcs:npcBanditMask");
			quest = new ItemNpcInterface(26958).setUnlocalizedName("npcBrokenArrow").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcBrokenArrow");
			quest = new ItemNpcInterface(26959).setUnlocalizedName("npcEarthElement").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcEarthElement");
			quest = new ItemNpcInterface(26960).setUnlocalizedName("npcWaterElement").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcWaterElement");
			quest = new ItemNpcInterface(26961).setUnlocalizedName("npcFireElement").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcFireElement");
			quest = new ItemNpcInterface(26962).setUnlocalizedName("npcAirElement").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcAirElement");
			
			quest = new ItemNpcInterface(26963).setUnlocalizedName("npcCarKey").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcCarKey");
			quest = new ItemNpcInterface(26964).setUnlocalizedName("npcKey").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcKey");
			quest = new ItemNpcInterface(26965).setUnlocalizedName("npcKey2").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcKey2");
			quest = new ItemNpcInterface(26966).setUnlocalizedName("npcPendant").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcPendant");
			quest = new ItemNpcInterface(26967).setUnlocalizedName("npcBlueprint").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcBlueprint");
			quest = new ItemNpcInterface(26968).setUnlocalizedName("npcRing").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcRing");
			quest = new ItemNpcInterface(26969).setUnlocalizedName("npcSkull").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcSkull");
	
			Item sapphire = new ItemNpcInterface(26970).setUnlocalizedName("npcSaphire").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcSaphire");
			Item ruby = new ItemNpcInterface(26971).setUnlocalizedName("npcRuby").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcRuby");
			Item amethyst = new ItemNpcInterface(26972).setUnlocalizedName("npcAmethyst").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcAmethyst");

			OreDictionary.registerOre("gemSaphire", sapphire);
			OreDictionary.registerOre("gemRuby", ruby);
			OreDictionary.registerOre("gemAmethyst", amethyst);
			
			bronze_ingot = new ItemNpcInterface(26973).setUnlocalizedName("npcBronzeIngot").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcBronzeIngot");
			demonic_ingot = new ItemNpcInterface(26973).setUnlocalizedName("npcDemonicIngot").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcDemonicIngot");
			mithril_ingot = new ItemNpcInterface(26973).setUnlocalizedName("npcMithrilIngot").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcMithrilIngot");

			armorMithril.customCraftingMaterial = mithril_ingot;
			
			bronze.customCraftingMaterial = bronze_ingot;
			emerald.customCraftingMaterial = Items.emerald;
			demonic.customCraftingMaterial = demonic_ingot;
			frost.customCraftingMaterial = Item.getItemFromBlock(Blocks.ice);
			mithril.customCraftingMaterial = mithril_ingot;
			
			OreDictionary.registerOre("ingotBronze", bronze_ingot);
			OreDictionary.registerOre("ingotDemonic", demonic_ingot);
			OreDictionary.registerOre("ingotMithril", mithril_ingot);
			
			quest = new ItemNpcInterface().setUnlocalizedName("npcAncientScroll").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcAncientScroll");
			quest = new ItemNpcInterface().setUnlocalizedName("npcArtifact").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcArtifact");
			quest = new ItemNpcInterface().setUnlocalizedName("npcLocket").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcLocket");
			quest = new ItemNpcInterface().setUnlocalizedName("npcSilk").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcSilk");
			quest = new ItemNpcInterface().setUnlocalizedName("npcStatuette").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcStatuette");
			quest = new ItemNpcInterface().setUnlocalizedName("npcTablet").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcTablet");

			quest = new ItemNpcInterface().setUnlocalizedName("npcHeart").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcHeart");
			quest = new ItemNpcInterface().setUnlocalizedName("npcMoney").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcMoney");
			quest = new ItemNpcInterface().setUnlocalizedName("npcNecklace").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcNecklace");
			quest = new ItemNpcInterface().setUnlocalizedName("npcUsbStick").setCreativeTab(CustomItems.tabMisc).setTextureName("customnpcs:npcUsbStick");
			
			tabArmor.item = armor;
			tabWeapon.item = CustomItems.coinDiamond;
			tabMisc.item = CustomItems.coinGold;
			tabBlocks.item = Item.getItemFromBlock(couchWool);
			tabBlocks.meta = 1;
		}
		
		tab.item = wand;
	}
}

import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;

/**
 * Used for synthese items.
 * 
 * @author Xiao Zhang and Delun Sun
 * @version 2021.01.28
 */
public class Recipes
{

    // Hashmaps to store synthesis items.
    private static HashMap<String,String> basicRecipes=new HashMap<String,String>();
    private static HashMap<String,String> toolRecipes=new HashMap<String,String>();
    private static HashMap<String,String> stoveRecipes=new HashMap<String,String>();
    private static HashMap<String,String> ShortToName=new HashMap<String,String>();
    private static HashMap<String,String> NameToShort=new HashMap<String,String>();

    
    static
    {
        constructBasicRecipes();
        constructToolRecipes();
        stoveRecipes();
        constuctShortToName();
        constuctNameToShort();
    }
 
private static void constuctShortToName(){
    ShortToName.put("do", "diamond_ore");
    ShortToName.put("go", "gold_ore");
    ShortToName.put("d", "dirt");
    ShortToName.put("co", "coal_ore");
    ShortToName.put("io", "iron_ore");
    ShortToName.put("so", "stone_ore");
    ShortToName.put("s", "stone");
    ShortToName.put("gs", "grass_side");
    ShortToName.put("ls", "log_spruce");
}
private static void constuctNameToShort(){
    NameToShort.put("diamond_ore","do");
    NameToShort.put( "gold_ore","go");
    NameToShort.put( "dirt","d");
    NameToShort.put( "coal_ore","co");
    NameToShort.put( "iron_ore","io");
    NameToShort.put( "stone_ore","so");
    NameToShort.put("stone","s");
    NameToShort.put("grass_side","gs");
    NameToShort.put("log_spruce","ls");
}
public static String getKeyShortToName(String str){
    return ShortToName.get(str);
}  

public static String getKeyNameToShort(String str){
    return NameToShort.get(str);
}  
    /**
     * Add all basic synthesis into hashmap.
     */
    private static void constructBasicRecipes()
    {
        basicRecipes.put("&WoodPlankWoodPlankWoodPlankWoodPlankWoodPlankWoodPlankWoodPlankWoodPlank", "Chest");
        basicRecipes.put("&&&&&WoodPlankWoodPlankWoodPlankWoodPlank", "CraftingTable");
        basicRecipes.put("&FurnaceFurnaceFurnaceFurnaceFurnaceFurnaceFurnaceFurnace", "Cobblestone");
        basicRecipes.put("&&&&&&&WoodPlankWoodPlank", "Sticks"/*4 sticks*/);
        basicRecipes.put("&&&&&&&CoalStick", "Torches"/*4 torches*/);
        basicRecipes.put("&&&&&&&&Wood", "WoodPlanks"/*4 WoodPlanks*/);
    }
    
    /**
     * Add all tool synthesis into hashmap.
     */
    private static void constructToolRecipes()
    {
        toolRecipes.put("&&&&StickStickWoodPlankWoodPlankWoodPlank", "Axes");
        toolRecipes.put("&&&&&&IronIngotIronIngotIronIngot", "Bucket");
        toolRecipes.put("&&&&CompassGoldIngotGoldIngotGoldIngotGoldIngot", "Clock");
        toolRecipes.put("&&&&IronIngotIronIngotIronIngotInronIngotRedstoneDust", "Compass");
        toolRecipes.put("&&&&&&&FlintIronIngot", "FlintandSteel");
        toolRecipes.put("&&&&&StickStickWoodPlankWoodPlank", "Hoes");
        toolRecipes.put("CompassPaperPaperPaperPaperPaperPaperPaperPaper", "Map");
        toolRecipes.put("&&&&&&&IronIngotIronIngot", "Shears");
        toolRecipes.put("&&&&&&StickStickWoodPlank", "Shovels");
        toolRecipes.put("&&&&&&FeatherFlintStick", "Arrow"/*4 arrows*/);
        toolRecipes.put("&&&StickStickStickStringStringString", "Bow");
        toolRecipes.put("&&IronIngotWoodPlankWoodPlankWoodPlankWoodPlankWoodPlankWoodPlank", "Shield");
        toolRecipes.put("&&&&&&StickWoodPlankWoodPlank", "Swords");
        toolRecipes.put("&&&&&LeatherLeatherLeatherLeather", "Boots");
        toolRecipes.put("&LeatherLeatherLeatherLeatherLeatherLeatherLeatherLeather", "Chestplates");
        toolRecipes.put("&&&&LeatherLeatherLeatherLeatherLeather", "Helmets");
        toolRecipes.put("&&&&&&&CobblestoneDiorite", "Andesite"/*2 Andesites*/);
        toolRecipes.put("CoalCoalCoalCoalCoalCoalCoalCoalCoal", "BlockofCoal");
        toolRecipes.put("&&&&&NetherQuartzNetherQuartzNetherQuartzNetherQuartz", "BlockofQuartz");
        toolRecipes.put("RedstoneRedstoneRedstoneRedstoneRedstoneRedstoneRedstoneRedstoneRedstone", "BlockofRedstone");
        toolRecipes.put("BookBookBookWoodPlankWoodPlankWoodPlankWoodPlankWoodPlankWoodPlank", "Bookshelf");
        toolRecipes.put("&&&&&BrickBrickBrickBrick", "BrickBlock");
        toolRecipes.put("&&&&&ClayClayClayClay", "ClayBlock");
        toolRecipes.put("&&&&&EndStoneEndStoneEndStoneEndStone", "EndStoneBricks"/*4 EndStoneBricks*/);
        toolRecipes.put("&&&&&&&PumpkinTorch", "Jack-O-Lantern");
        toolRecipes.put("&&&&&MagmaCreamMagmaCreamMagmaCreamMagmaCream", "MagmaBlock");
        toolRecipes.put("NetherWartNetherWartNetherWartNetherWartNetherWartNetherWartNetherWartNetherWartNetherWart", "NetherWartBlock");
        toolRecipes.put("&&&&&PrismarineShardPrismarineShardPrismarineShardPrismarineShard", "Prismarine");
        toolRecipes.put("PrismarineShardPrismarineShardPrismarineShardPrismarineShardPrismarineShardPrismarineShardPrismarineShardPrismarineShardPrismarineShard", "PrismarineBricks");
        toolRecipes.put("&&&&&SandSandSandSand", "Sandstone");
        toolRecipes.put("&&&&IronIngotIronIngotIronIngotIronIngotIronIngot", "Minecart");
        toolRecipes.put("&&&&&&&ChestMinecart", "MinecartwithChest");
        toolRecipes.put("&&&&&&&FurnaceMinecart", "PoweredMinecart");
        toolRecipes.put("&&&WoodPlankWoodPlankWoodPlankWoodPlankWoodPlankWoodPlank", "Doors"/*3Doors*/);
        toolRecipes.put("&&&&&IronIngotIronIngotIronIngotIronIngot", "IronTrapdoor");
        toolRecipes.put("&&&WoodPlankWoodPlankWoodPlankWoodPlankWoodPlankWoodPlank", "Trapdoor"/*2Trapdoors*/);
        toolRecipes.put("&&&&&&IronIngotStickWoodPlank", "TripwireHooks"/*2TripwireHooks*/);
        toolRecipes.put("&&&&&&&ChestTripwireHook", "TrappedChest");
        toolRecipes.put("&&&&&&CocoaBeansWheatWheat", "Cookies"/*8Cookies*/);
        toolRecipes.put("AppleGoldIngotGoldIngotGoldIngotGoldIngotGoldIngotGoldIngotGoldIngotGoldIngot", "GoldenApple");
        toolRecipes.put("&&&&&&EggPumpkinSugar", "PumpkinPie");
        toolRecipes.put("&&&CobblestoneCobblestoneCobblestoneCobblestoneCobblestoneCobblestone", "CobblestoneWall"/*6CobblestoneWalls*/);
        toolRecipes.put("&&&StickStickWoodPlankWoodPlankWoodPlankWoodPlank", "Fence"/*3Fences*/);
        toolRecipes.put("&&StickStickStickStickStickStickStick", "Ladders"/*3Ladders*/);
        toolRecipes.put("StickStickStickStickStickStickStickStickWool", "Painting");
        toolRecipes.put("&&StickWoodPlankWoodPlankWoodPlankWoodPlankWoodPlankWoodPlank", "Signs"/*3Signs*/);
        toolRecipes.put("&&&&&&GlassGlassGlass", "GlassBottles"/*3GlassBottles*/);
        toolRecipes.put("&&&&&&&&Bone", "BoneMeal"/*3BoneMeals*/);
        toolRecipes.put("&&&&&&&BoneMealInkSac", "GrayDyes"/*2GrayDyes*/);
        toolRecipes.put("&&&&&&&BoneMealLapsisLazuli", "LightBlueDyes"/*2LightBlueDyes*/);
        toolRecipes.put("&&&&&StringStringStringString", "Wool");
        toolRecipes.put("&&&&&&&InkSacWool", "BlackWool");
        toolRecipes.put("&&&&&&&LapisLazuliWool", "BlueWool");
        toolRecipes.put("&&&&&&&CocoaBeanWool", "BrownWool");
    }
    
    /**
     * Add all stove synthesis into hashmap.
     */
    private static void stoveRecipes()
    {
        stoveRecipes.put("FuelPotato", "BakedPotato");
        stoveRecipes.put("FuelRawChicken", "CookedChicken");
        stoveRecipes.put("FuelRawFish", "CookedFish");
        stoveRecipes.put("FuelRawPorkchop", "CookedPorkchop");
        stoveRecipes.put("FuelRawBeef", "Steak");
        stoveRecipes.put("ClayFuel", "ClayBrick");
        stoveRecipes.put("FuelSand", "Glass");
        stoveRecipes.put("FuelGoldOre", "GoldIngot");
        stoveRecipes.put("FuelIronOre", "IronIngot");
        stoveRecipes.put("FuelNetherrack", "NetherBrick");
        stoveRecipes.put("CobblestoneFuel", "Stone");
        stoveRecipes.put("FuelWood", "Charcoal");
        stoveRecipes.put("CoalOreFuel", "Coal");
        stoveRecipes.put("DiamondOreFuel", "Diamond");
        stoveRecipes.put("EmeraldOreFuel", "Emerald");
        stoveRecipes.put("FuelLapisLazuliOre", "LapisLazuli");
        stoveRecipes.put("FuelNetherQuartzOre", "NetherQuartz");
        stoveRecipes.put("FuelRedstoneOre", "RedstoneDust");
    }
    

    /**
     * Synthesis process for two items.
     * 
     * @param first The name of the first item.
     * @param second The name of the second item.   
     */
    public static String synthesis(String first, String second)
    {
        String temp;
        int length = 2;
        String str[] = new String[2];
        str[0] = first;
        str[1] = second;  
        Arrays.sort(str);
        first = str[0];
        second = str[1];
        temp= first+second;
        if(stoveRecipes.containsKey(temp))
        {
            return stoveRecipes.get(temp);
        }
        return null;
    }
    
    /**
     * Synthesis process for nine items.
     * 
     * @param first The name of the first item.
     * @param second The name of the second item. 
     * @param third The name of the third item.
     * @param fourth The name of the fourth item.
     * @param fifth The name of the fifth item.
     * @param sixth The name of the sixth item.
     * @param seventh The name of the seventh item.
     * @param eighth The name of the eighth item.
     * @param ninth The name of the ninth item.
     * 
     */
    public static String synthesis(String first, String second, String third, String fourth, String fifth, String sixth, String seventh, String eighth, String ninth)
    {
        String temp;
        int length = 9;
        String str[] = new String[9];
        str[0] = first;
        str[1] = second;
        str[2] = third;
        str[3] = fourth;
        str[4] = fifth;
        str[5] = sixth;
        str[6] = seventh;
        str[7] = eighth;
        str[8] = ninth;
        for(int i = 0; i<9;i++)
        {
            if(str[i].equals(null))
            {
                str[i] = "&";
            }
        }
        Arrays.sort(str);
        first = str[0];
        second = str[1];
        third = str[2];
        fourth = str[3];
        fifth = str[4];
        sixth = str[5];
        seventh = str[6];
        eighth = str[7];
        ninth = str[8];
        temp = first+second+third+fourth+fifth+sixth+seventh+eighth+ninth;
        if(basicRecipes.containsKey(temp))
        {
            return basicRecipes.get(temp);
        }
        if(toolRecipes.containsKey(temp))
        {
            return toolRecipes.get(temp);
        }
        return null;
    }    
    
}

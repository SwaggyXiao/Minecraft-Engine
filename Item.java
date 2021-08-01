import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;

/**
 * Item class is used to create items in the game.
 * 
 * @author Xiao Zhang and Delun Sun 
 * @version 2021.01.28
 */
public class Item extends Actor
{ 
    // Variables used in Item class.
    private int number;
    private int num2 = 0; 
    private String name;
    private GreenfootImage image;
    private GreenfootImage bigImage;
    private GreenfootImage number1;
    private GreenfootImage number2;
    private Item newItem;
    private static final int clear = 0,half = 1, decreaseOne = 2;
    private static final int zero = 0,one = 1, two = 2, three = 3, four = 4,
    five = 5, six = 6, seven = 7, eight = 8, nine = 9;
    
    // Hashmap to store all items in it.
    private static HashMap<String,GreenfootImage>  itemImage=new HashMap<String,GreenfootImage>();
    
    // Store all item images into hashmap.
    static
    {
        itemImage.put("wood_plank",new GreenfootImage("items/wood_plank.png"));//
        itemImage.put("chest",new GreenfootImage("items/chest.png"));//
        itemImage.put("crafting_table",new GreenfootImage("items/crafting_table.png"));//
        itemImage.put("furnace",new GreenfootImage("items/furnace.png"));//
        itemImage.put("stick",new GreenfootImage("items/stick.png"));//
        itemImage.put("coal",new GreenfootImage("items/coal.png"));//
        itemImage.put("torch",new GreenfootImage("items/torch.png"));//
        itemImage.put("log_spruce",new GreenfootImage("items/wood.png"));//
        itemImage.put("axes",new GreenfootImage("items/axes.png"));//
        itemImage.put("iron_ingot",new GreenfootImage("items/iron_ingot.png"));//
        itemImage.put("bucket",new GreenfootImage("items/bucket.png"));//
        itemImage.put("compass",new GreenfootImage("items/compass.png"));//
        itemImage.put("gold_ingot",new GreenfootImage("items/gold_ingot.png"));//
        itemImage.put("clock",new GreenfootImage("items/clock.png"));//
        itemImage.put("redstone_dust",new GreenfootImage("items/redstone_dust.png"));//
        itemImage.put("flint",new GreenfootImage("items/flint.png"));//
        itemImage.put("flint_and_steel",new GreenfootImage("items/flint_and_steel.png"));//
        itemImage.put("hoe",new GreenfootImage("items/hoe.png"));//
        itemImage.put("paper",new GreenfootImage("items/paper.png"));//
        itemImage.put("map",new GreenfootImage("items/map.png"));//
        itemImage.put("shears",new GreenfootImage("items/shears.png"));//
        itemImage.put("shovel",new GreenfootImage("items/shovel.png"));//
        itemImage.put("feather",new GreenfootImage("items/feather.png"));//
        itemImage.put("arrow",new GreenfootImage("items/arrow.png"));//
        itemImage.put("string",new GreenfootImage("items/string.png"));//
        itemImage.put("bow",new GreenfootImage("items/bow.png"));//
        itemImage.put("shield",new GreenfootImage("items/shield.png"));//
        itemImage.put("sword",new GreenfootImage("items/sword.png"));//
        itemImage.put("leather",new GreenfootImage("items/leather.png"));//
        itemImage.put("boots",new GreenfootImage("items/boots.png"));//
        itemImage.put("chestplate",new GreenfootImage("items/chestplate.png"));//
        itemImage.put("helmet",new GreenfootImage("items/helmet.png"));//
        itemImage.put("diorite",new GreenfootImage("items/diorite.png"));//
        itemImage.put("andesite",new GreenfootImage("items/andesite.png"));//
        itemImage.put("block_of_coal",new GreenfootImage("items/block_of_coal.png"));//
        itemImage.put("nether_quartz",new GreenfootImage("items/nether_quartz.png"));//
        itemImage.put("block_of_quartz",new GreenfootImage("items/block_of_quartz.png"));//
        itemImage.put("redstone",new GreenfootImage("items/redstone.png"));//
        itemImage.put("block_of_redstone",new GreenfootImage("items/block_of_redstone.png"));//
        itemImage.put("book",new GreenfootImage("items/book.png"));//
        itemImage.put("bookshelf",new GreenfootImage("items/bookshelf.png"));//
        itemImage.put("brick",new GreenfootImage("items/brick.png"));//
        itemImage.put("brick_block",new GreenfootImage("items/brick_block.png"));//
        itemImage.put("clay",new GreenfootImage("items/clay.png"));//
        itemImage.put("clay_block",new GreenfootImage("items/clay_block.png"));//
        itemImage.put("end_stone",new GreenfootImage("items/end_stone.png"));//
        itemImage.put("end_stone_brick",new GreenfootImage("items/end_stone_brick.png"));//
        itemImage.put("pumpkin",new GreenfootImage("items/pumpkin.png"));//
        itemImage.put("jack_o_lantern",new GreenfootImage("items/jack_o_lantern.png"));//
        itemImage.put("magma_cream",new GreenfootImage("items/magma_cream.png"));//
        itemImage.put("magma_block",new GreenfootImage("items/magma_block.png"));//
        itemImage.put("nether_wart",new GreenfootImage("items/nether_wart.png"));//
        itemImage.put("nether_wart_block",new GreenfootImage("items/nether_wart_block.png"));//
        itemImage.put("prismarine_shard",new GreenfootImage("items/prismarine_shard.png"));//
        itemImage.put("prismarine",new GreenfootImage("items/prismarine.png"));//
        itemImage.put("prismarine_brick",new GreenfootImage("items/prismarine_brick.png"));//
        itemImage.put("sand",new GreenfootImage("items/sand.png"));//
        itemImage.put("sandstone",new GreenfootImage("items/sandstone.png"));//
        itemImage.put("minecart",new GreenfootImage("items/minecart.png"));//
        itemImage.put("minecart_with_chest",new GreenfootImage("items/minecart_with_chest.png"));//
        itemImage.put("powered_minecart",new GreenfootImage("items/powered_minecart.png"));//
        itemImage.put("door",new GreenfootImage("items/door.png"));//
        itemImage.put("iron_trapdoor",new GreenfootImage("items/iron_trapdoor.png"));//
        itemImage.put("trapdoor",new GreenfootImage("items/trapdoor.png"));//
        itemImage.put("tripwire_hook",new GreenfootImage("items/tripwire_hook.png"));//
        itemImage.put("trapped_chest",new GreenfootImage("items/trapped_chest.png"));//
        itemImage.put("cocoa_bean",new GreenfootImage("items/cocoa_bean.png"));//
        itemImage.put("wheat",new GreenfootImage("items/wheat.png"));//
        itemImage.put("cookie",new GreenfootImage("items/cookie.png"));//
        itemImage.put("apple",new GreenfootImage("items/apple.png"));//
        itemImage.put("egg",new GreenfootImage("items/egg.png"));//
        itemImage.put("pumpkin",new GreenfootImage("items/pumpkin.png"));//
        itemImage.put("sugar",new GreenfootImage("items/sugar.png"));//
        itemImage.put("pumpkin_pie",new GreenfootImage("items/pumpkin_pie.png"));//
        itemImage.put("cobblestone",new GreenfootImage("items/cobblestone.png"));//
        itemImage.put("cobblestone_wall",new GreenfootImage("items/cobblestone_wall.png"));//
        itemImage.put("fence",new GreenfootImage("items/fence.png"));//
        itemImage.put("ladder",new GreenfootImage("items/ladder.png"));//
        itemImage.put("painting",new GreenfootImage("items/painting.png"));//
        itemImage.put("sign",new GreenfootImage("items/sign.png"));//
        itemImage.put("glass",new GreenfootImage("items/glass.png"));//
        itemImage.put("glass_bottle",new GreenfootImage("items/glass_bottle.png"));//
        itemImage.put("bone",new GreenfootImage("items/bone.png"));//
        itemImage.put("bone_meal",new GreenfootImage("items/bone_meal.png"));//
        itemImage.put("ink_sac",new GreenfootImage("items/ink_sac.png"));//
        itemImage.put("gray_dye",new GreenfootImage("items/gray_dye.png"));//
        itemImage.put("lapsis_lazuli",new GreenfootImage("items/lapsis_lazuli.png"));//
        itemImage.put("light_blue_dye",new GreenfootImage("items/light_blue_dye.png"));//
        itemImage.put("wool",new GreenfootImage("items/wool.png"));//
        itemImage.put("black_wool",new GreenfootImage("items/black_wool.png"));//
        itemImage.put("blue_wool",new GreenfootImage("items/blue_wool.png"));//
        itemImage.put("brown_wool",new GreenfootImage("items/brown_wool.png"));//
        itemImage.put("fuel",new GreenfootImage("items/fuel.png"));//
        itemImage.put("potato",new GreenfootImage("items/potato.png"));//
        itemImage.put("baked_potato",new GreenfootImage("items/baked_potato.png"));//
        itemImage.put("raw_chicken",new GreenfootImage("items/raw_chicken.png"));//
        itemImage.put("cooked_chicken",new GreenfootImage("items/cooked_chicken.png"));//
        itemImage.put("raw_fish",new GreenfootImage("items/raw_fish.png"));//
        itemImage.put("cooked_fish",new GreenfootImage("items/cooked_fish.png"));//
        itemImage.put("raw_porkchop",new GreenfootImage("items/raw_porkchop.png"));//
        itemImage.put("cooked_porkchop",new GreenfootImage("items/cooked_porkchop.png"));//
        itemImage.put("raw_beef",new GreenfootImage("items/raw_beef.png"));//
        itemImage.put("steak",new GreenfootImage("items/steak.png"));//
        itemImage.put("clay_brick",new GreenfootImage("items/clay_brick.png"));//
        itemImage.put("gold_ore",new GreenfootImage("items/gold_ore.png"));//
        itemImage.put("iron_ore",new GreenfootImage("items/iron_ore.png"));//
        itemImage.put("netherrack",new GreenfootImage("items/netherrack.png"));//
        itemImage.put("nether_brick",new GreenfootImage("items/nether_brick.png"));//
        itemImage.put("stone",new GreenfootImage("items/cobblestone.png"));//
        itemImage.put("coal_ore",new GreenfootImage("items/coal_ore.png"));//
        itemImage.put("diamond_ore",new GreenfootImage("items/diamond_ore.png"));//
        itemImage.put("emerald_ore",new GreenfootImage("items/emerald_ore.png"));//
        itemImage.put("lapis_lazuli_ore",new GreenfootImage("items/lapis_lazuli_ore.png"));//
        itemImage.put("nether_quartz_ore",new GreenfootImage("items/nether_quartz_ore.png"));//
        itemImage.put("redstone_ore",new GreenfootImage("items/redstone_ore.png"));//
        itemImage.put("diamond",new GreenfootImage("items/diamond.png"));//
        itemImage.put("emerald",new GreenfootImage("items/emerald.png"));//
        itemImage.put("dirt",new GreenfootImage("items/dirt block.png"));//
        itemImage.put("grass_side",new GreenfootImage("items/dirt block.png"));//
        
    }
    /**
     * Constructor for objects of class Item.
     * 
     * @param name  The name of the item.
     * @param number   The number of an item.
     *       
     */
    public Item(String name, int number)
    {
        bigImage = new GreenfootImage(40,40);
        this.name = name;
        this.number = number;
        if(itemImage.containsKey(name))
        {
            image = itemImage.get(name);
        }
        image.scale(35,35);
        bigImage.drawImage(image,0,0);
        int num1 = number/10;
        int num2 = number%10;
        // In different number display different number images.
        switch(num1)
        {
            case zero:
            {
                number1 = new GreenfootImage("numbers/0.png");
                
            }
            break;
            
            case one:
            {
                number1 = new GreenfootImage("numbers/1.png");
                
            }
            break;
            
            case two:
            {
                number1 = new GreenfootImage("numbers/2.png");
                
            }
            break;
            
            case three:
            {
                number1 = new GreenfootImage("numbers/3.png");
            }
            break;
            
            case four:
            {
                number1 = new GreenfootImage("numbers/4.png");
               
            }
            break;
            
            case five:
            {
                number1 = new GreenfootImage("numbers/5.png");
                
            }
            break;
            
            case six:
            {
                number1 = new GreenfootImage("numbers/6.png");
                
            }
            break;
            
            case seven:
            {
                number1 = new GreenfootImage("numbers/7.png");
                
            }
            break;
            
            case eight:
            {
                number1 = new GreenfootImage("numbers/8.png");
                
            }
            break;
            
            case nine:
            {
                number1 = new GreenfootImage("numbers/9.png");
                
            }
            break;
        }
        // In different number display different number images.
        switch(num2)
        {
            case zero:
            {
                number2 = new GreenfootImage("numbers/0.png");
            }
            break;
            
            case one:
            {
                number2 = new GreenfootImage("numbers/1.png");
                
            }
            break;
            
            case two:
            {
                number2 = new GreenfootImage("numbers/2.png");
                
            }
            break;
            
            case three:
            {
                number2 = new GreenfootImage("numbers/3.png");
                
            }
            break;
            
            case four:
            {
                number2 = new GreenfootImage("numbers/4.png");
               
            }
            break;
            
            case five:
            {
                number2 = new GreenfootImage("numbers/5.png");
                
            }
            break;
            
            case six:
            {
                number2 = new GreenfootImage("numbers/6.png");
                
            }
            break;
            
            case seven:
            {
                number2 = new GreenfootImage("numbers/7.png");
                
            }
            break;
            
            case eight:
            {
                number2 = new GreenfootImage("numbers/8.png");
                
            }
            break;
            
            case nine:
            {
                number2 = new GreenfootImage("numbers/9.png");
                
            }
            break;
        }
        bigImage.drawImage(number1,25,25);
        bigImage.drawImage(number2,30,25);
        setImage(bigImage);
    }
    
    /**
     * Add number of an item into it.
     * 
     * @param addValue  The number of item being added.
     */
    public void addNumber(int addValue)
    {
        number += addValue; 
        // One item cannot have a number of bigger than 64.
        if(number>64)
        {
            number = 64;
            bigImage.clear();
            number1.clear();
            number2.clear();
            if(itemImage.containsKey(name))
            {
                image = itemImage.get(name);
            }
            image.scale(35,35);
            int num1 = number/10;
            int num2 = number%10;
            
            // In different number display different number images.
            switch(num1)
            {
                case zero:
                {
                    number1 = new GreenfootImage("numbers/0.png");
                    
                }
                break;
                
                case one:
                {
                    number1 = new GreenfootImage("numbers/1.png");
                    
                }
                break;
                
                case two:
                {
                    number1 = new GreenfootImage("numbers/2.png");
                    
                }
                break;
                
                case three:
                {
                    number1 = new GreenfootImage("numbers/3.png");
                    
                }
                break;
                
                case four:
                {
                    number1 = new GreenfootImage("numbers/4.png");
                   
                }
                break;
                
                case five:
                {
                    number1 = new GreenfootImage("numbers/5.png");
                    
                }
                break;
                
                case six:
                {
                    number1 = new GreenfootImage("numbers/6.png");
                    
                }
                break;
                
                case seven:
                {
                    number1 = new GreenfootImage("numbers/7.png");
                    
                }
                break;
                
                case eight:
                {
                    number1 = new GreenfootImage("numbers/8.png");
                    
                }
                break;
                
                case nine:
                {
                    number1 = new GreenfootImage("numbers/9.png");
                    
                }
                break;
            }
            // In different number display different number images.
            switch(num2)
            {
                case zero:
                {
                    number2 = new GreenfootImage("numbers/0.png");
                }
                break;
                
                case one:
                {
                    number2 = new GreenfootImage("numbers/1.png");
                    
                }
                break;
                
                case two:
                {
                    number2 = new GreenfootImage("numbers/2.png");
                    
                }
                break;
                
                case three:
                {
                    number2 = new GreenfootImage("numbers/3.png");
                    
                }
                break;
                
                case four:
                {
                    number2 = new GreenfootImage("numbers/4.png");
                   
                }
                break;
                
                case five:
                {
                    number2 = new GreenfootImage("numbers/5.png");
                    
                }
                break;
                
                case six:
                {
                    number2 = new GreenfootImage("numbers/6.png");
                    
                }
                break;
                
                case seven:
                {
                    number2 = new GreenfootImage("numbers/7.png");
                    
                }
                break;
                
                case eight:
                {
                    number2 = new GreenfootImage("numbers/8.png");
                    
                }
                break;
                
                case nine:
                {
                    number2 = new GreenfootImage("numbers/9.png");
                    
                }
                break;
            }
            bigImage.drawImage(image,0,0);
            bigImage.drawImage(number1,25,25);
            bigImage.drawImage(number2,30,25);
            setImage(bigImage);
        }
        else
        {
            bigImage.clear();
            number1.clear();
            number2.clear();
            if(itemImage.containsKey(name))
            {
                image = itemImage.get(name);
            }
            image.scale(35,35);
            int num1 = number/10;
            int num2 = number%10;
        
            // In different number display different number images.
            switch(num1)
            {
                case zero:
                {
                    number1 = new GreenfootImage("numbers/0.png");
                    
                }
                break;
                
                case one:
                {
                    number1 = new GreenfootImage("numbers/1.png");
                    
                }
                break;
                
                case two:
                {
                    number1 = new GreenfootImage("numbers/2.png");
                    
                }
                break;
                
                case three:
                {
                    number1 = new GreenfootImage("numbers/3.png");
                    
                }
                break;
                
                case four:
                {
                    number1 = new GreenfootImage("numbers/4.png");
                   
                }
                break;
                
                case five:
                {
                    number1 = new GreenfootImage("numbers/5.png");
                    
                }
                break;
                
                case six:
                {
                    number1 = new GreenfootImage("numbers/6.png");
                    
                }
                break;
                
                case seven:
                {
                    number1 = new GreenfootImage("numbers/7.png");
                    
                }
                break;
                
                case eight:
                {
                    number1 = new GreenfootImage("numbers/8.png");
                    
                }
                break;
                
                case nine:
                {
                    number1 = new GreenfootImage("numbers/9.png");
                    
                }
                break;
            }
            // In different number display different number images.
            switch(num2)
            {
                case zero:
                {
                    number2 = new GreenfootImage("numbers/0.png");
                }
                break;
                
                case one:
                {
                    number2 = new GreenfootImage("numbers/1.png");
                    
                }
                break;
                
                case two:
                {
                    number2 = new GreenfootImage("numbers/2.png");
                    
                }
                break;
                
                case three:
                {
                    number2 = new GreenfootImage("numbers/3.png");
                    
                }
                break;
                
                case four:
                {
                    number2 = new GreenfootImage("numbers/4.png");
                   
                }
                break;
                
                case five:
                {
                    number2 = new GreenfootImage("numbers/5.png");
                    
                }
                break;
                
                case six:
                {
                    number2 = new GreenfootImage("numbers/6.png");
                    
                }
                break;
                
                case seven:
                {
                    number2 = new GreenfootImage("numbers/7.png");
                    
                }
                break;
                
                case eight:
                {
                    number2 = new GreenfootImage("numbers/8.png");
                    
                }
                break;
                
                case nine:
                {
                    number2 = new GreenfootImage("numbers/9.png");
                    
                }
                break;
            }
            bigImage.drawImage(image,0,0);
            bigImage.drawImage(number1,25,25);
            bigImage.drawImage(number2,30,25);
            setImage(bigImage);
        }
    }
    
    /**
     * Decrease number of an item.
     * 
     * @param diff  The different cases represented in integer.
     */
    public void decreaseNumber(int diff)
    {
        bigImage.clear();
        number1.clear();
        number2.clear();
        if(itemImage.containsKey(name))
        {
            image = itemImage.get(name);
        }
        image.scale(35,35);
        // Different cases will decrease different numbers of an item.
        switch(diff)
        {
            case clear:
            {
                number = 0;
            }
            break;
            
            case half:
            {
                number /= 2;
            }
            break;
            
            case decreaseOne:
            {
                number --;
            }
            break;
        }
        int num1 = number/10;
        int num2 = number%10;
        // In different number display different number images.
            switch(num1)
            {
                case zero:
                {
                    number1 = new GreenfootImage("numbers/0.png");
                    
                }
                break;
                
                case one:
                {
                    number1 = new GreenfootImage("numbers/1.png");
                    
                }
                break;
                
                case two:
                {
                    number1 = new GreenfootImage("numbers/2.png");
                    
                }
                break;
                
                case three:
                {
                    number1 = new GreenfootImage("numbers/3.png");
                    
                }
                break;
                
                case four:
                {
                    number1 = new GreenfootImage("numbers/4.png");
                   
                }
                break;
                
                case five:
                {
                    number1 = new GreenfootImage("numbers/5.png");
                    
                }
                break;
                
                case six:
                {
                    number1 = new GreenfootImage("numbers/6.png");
                    
                }
                break;
                
                case seven:
                {
                    number1 = new GreenfootImage("numbers/7.png");
                    
                }
                break;
                
                case eight:
                {
                    number1 = new GreenfootImage("numbers/8.png");
                    
                }
                break;
                
                case nine:
                {
                    number1 = new GreenfootImage("numbers/9.png");
                    
                }
                break;
            }
            // In different number display different number images.
            switch(num2)
            {
                case zero:
                {
                    number2 = new GreenfootImage("numbers/0.png");
                }
                break;
                
                case one:
                {
                    number2 = new GreenfootImage("numbers/1.png");
                    
                }
                break;
                
                case two:
                {
                    number2 = new GreenfootImage("numbers/2.png");
                    
                }
                break;
                
                case three:
                {
                    number2 = new GreenfootImage("numbers/3.png");
                    
                }
                break;
                
                case four:
                {
                    number2 = new GreenfootImage("numbers/4.png");
                   
                }
                break;
                
                case five:
                {
                    number2 = new GreenfootImage("numbers/5.png");
                    
                }
                break;
                
                case six:
                {
                    number2 = new GreenfootImage("numbers/6.png");
                    
                }
                break;
                
                case seven:
                {
                    number2 = new GreenfootImage("numbers/7.png");
                    
                }
                break;
                
                case eight:
                {
                    number2 = new GreenfootImage("numbers/8.png");
                    
                }
                break;
                
                case nine:
                {
                    number2 = new GreenfootImage("numbers/9.png");
                    
                }
                break;
            }
        bigImage.drawImage(image,0,0);
        bigImage.drawImage(number1,25,25);
        bigImage.drawImage(number2,30,25);
        setImage(bigImage);
    }
    
    private void createNew()
    {
        bigImage.clear();
        number1.clear();
        number2.clear();
        newItem = new Item(name, num2);
        getWorld().addObject(newItem,140,100);
    }
    
    /**
     * Return the number of an item.
     * 
     * @return  Number of an item.
     */
    public int getNumber()
    {
        return number;
    }
    
    /**
     * Return the name of the item.
     * 
     * @return The name of the item.
     */
    public String getName()
    {
        return name;
    }

}

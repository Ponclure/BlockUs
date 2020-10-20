execute at @s run playsound minecraft:kill master @s ~ ~ ~ 9999
effect give @s slowness 1 127 true

replaceitem entity @s hotbar.1 barrier
scoreboard players operation @s kill_cd = KillCDSec settings
scoreboard players operation @s kill_cd *= ticks_per_sec var

## Kill
execute if score KillDistance settings matches 0 as @a[tag=crewmate,tag=!ghost,distance=..4,limit=1,sort=nearest] at @s run function scripts:death
execute if score KillDistance settings matches 1 as @a[tag=crewmate,tag=!ghost,distance=..5,limit=1,sort=nearest] at @s run function scripts:death
execute if score KillDistance settings matches 2 as @a[tag=crewmate,tag=!ghost,distance=..6,limit=1,sort=nearest] at @s run function scripts:death

execute if score KillDistance settings matches 0 as @e[nbt={ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]},distance=..4,limit=1,sort=nearest] at @s run function scripts:death_connected
execute if score KillDistance settings matches 1 as @e[nbt={ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]},distance=..5,limit=1,sort=nearest] at @s run function scripts:death_connected
execute if score KillDistance settings matches 2 as @e[nbt={ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]},distance=..6,limit=1,sort=nearest] at @s run function scripts:death_connected


## Check if game ends
schedule function scripts:game_check 1s
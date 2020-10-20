tag @s remove venting
tag @s remove vent_system1
tag @s remove vent_system2
tag @s remove vent_system3
tag @s remove vent_system4
tag @s remove vent_system5
tag @s remove vent_system6
scoreboard players reset @s vent_number

## Move out
#setblock ~ ~-1 ~ minecraft:iron_trapdoor[open=true,half=top]
#schedule function scripts:reset_trapdoors 5
execute at @s run tp @s ~ ~1 ~
effect clear @s invisibility
execute as @s at @s run playsound minecraft:vent master @s ~ ~ ~ 9999

clear @s
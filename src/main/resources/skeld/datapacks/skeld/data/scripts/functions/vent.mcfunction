clear @s
scoreboard players reset @s click
execute as @s at @s run tp @s ~ ~-1 ~
setblock ~ ~-1 ~ minecraft:iron_trapdoor[open=true,half=top]
schedule function scripts:reset_trapdoors 10

scoreboard objectives add vent_number dummy
execute as @p at @s at @s run playsound minecraft:vent master @s ~ ~ ~ 9999

tag @s add venting

## System
# Vent System 1
execute if entity @e[tag=v1,distance=..2] run tag @s add vent_system1
execute if entity @e[tag=v2,distance=..2] run tag @s add vent_system1

# Vent System 2
execute if entity @e[tag=v3,distance=..2] run tag @s add vent_system2
execute if entity @e[tag=v4,distance=..2] run tag @s add vent_system2

# Vent System 3
execute if entity @e[tag=v5,distance=..2] run tag @s add vent_system3
execute if entity @e[tag=v6,distance=..2] run tag @s add vent_system3
execute if entity @e[tag=v7,distance=..2] run tag @s add vent_system3

# Vent System 4
execute if entity @e[tag=v8,distance=..2] run tag @s add vent_system4
execute if entity @e[tag=v9,distance=..2] run tag @s add vent_system4
execute if entity @e[tag=v10,distance=..2] run tag @s add vent_system4

# Vent System 5
execute if entity @e[tag=v11,distance=..2] run tag @s add vent_system5
execute if entity @e[tag=v12,distance=..2] run tag @s add vent_system5

# Vent System 6
execute if entity @e[tag=v13,distance=..2] run tag @s add vent_system6
execute if entity @e[tag=v14,distance=..2] run tag @s add vent_system6

## Number
# Vent System 1
execute if entity @e[tag=v1,distance=..2] run scoreboard players set @s vent_number 1
execute if entity @e[tag=v2,distance=..2] run scoreboard players set @s vent_number 2

# Vent System 2
execute if entity @e[tag=v3,distance=..2] run scoreboard players set @s vent_number 3
execute if entity @e[tag=v4,distance=..2] run scoreboard players set @s vent_number 4

# Vent System 3
execute if entity @e[tag=v5,distance=..2] run scoreboard players set @s vent_number 5
execute if entity @e[tag=v6,distance=..2] run scoreboard players set @s vent_number 6
execute if entity @e[tag=v7,distance=..2] run scoreboard players set @s vent_number 7

# Vent System 4
execute if entity @e[tag=v8,distance=..2] run scoreboard players set @s vent_number 8
execute if entity @e[tag=v9,distance=..2] run scoreboard players set @s vent_number 9
execute if entity @e[tag=v10,distance=..2] run scoreboard players set @s vent_number 10

# Vent System 5
execute if entity @e[tag=v11,distance=..2] run scoreboard players set @s vent_number 11
execute if entity @e[tag=v12,distance=..2] run scoreboard players set @s vent_number 12

# Vent System 6
execute if entity @e[tag=v13,distance=..2] run scoreboard players set @s vent_number 13
execute if entity @e[tag=v14,distance=..2] run scoreboard players set @s vent_number 14
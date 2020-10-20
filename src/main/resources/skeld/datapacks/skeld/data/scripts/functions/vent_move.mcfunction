scoreboard players add @s vent_number 1
execute as @s at @s run playsound minecraft:generic master @s ~ ~ ~ 9999

## Limits
execute as @s[tag=vent_system1] if score @s vent_number matches 3.. run scoreboard players set @s vent_number 1
execute as @s[tag=vent_system2] if score @s vent_number matches 5.. run scoreboard players set @s vent_number 3
execute as @s[tag=vent_system3] if score @s vent_number matches 8.. run scoreboard players set @s vent_number 5
execute as @s[tag=vent_system4] if score @s vent_number matches 11.. run scoreboard players set @s vent_number 8
execute as @s[tag=vent_system5] if score @s vent_number matches 13.. run scoreboard players set @s vent_number 11
execute as @s[tag=vent_system6] if score @s vent_number matches 15.. run scoreboard players set @s vent_number 13
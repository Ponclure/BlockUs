bossbar add o2 {"text":"Oxygen Depleting","color":"red"}
bossbar set minecraft:o2 style notched_10
bossbar set minecraft:o2 color red
bossbar set minecraft:o2 players @a
bossbar set minecraft:o2 max 600
worldborder warning distance 200000000

## Playsound
execute if score o2 sabotage matches 40 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999
execute if score o2 sabotage matches 80 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999
execute if score o2 sabotage matches 120 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999
execute if score o2 sabotage matches 160 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999
execute if score o2 sabotage matches 200 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999
execute if score o2 sabotage matches 240 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999
execute if score o2 sabotage matches 280 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999
execute if score o2 sabotage matches 320 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999
execute if score o2 sabotage matches 360 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999
execute if score o2 sabotage matches 400 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999
execute if score o2 sabotage matches 440 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999
execute if score o2 sabotage matches 480 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999
execute if score o2 sabotage matches 520 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999
execute if score o2 sabotage matches 560 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999

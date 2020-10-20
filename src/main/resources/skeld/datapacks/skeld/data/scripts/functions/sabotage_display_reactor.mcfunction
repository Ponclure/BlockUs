bossbar add reactor {"text":"Reactor Meltdown","color":"red"}
bossbar set minecraft:reactor style notched_10
bossbar set minecraft:reactor color red
bossbar set minecraft:reactor players @a
bossbar set minecraft:reactor max 600
worldborder warning distance 200000000

## Playsound
execute if score reactor sabotage matches 40 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999
execute if score reactor sabotage matches 80 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999
execute if score reactor sabotage matches 120 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999
execute if score reactor sabotage matches 160 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999
execute if score reactor sabotage matches 200 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999
execute if score reactor sabotage matches 240 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999
execute if score reactor sabotage matches 280 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999
execute if score reactor sabotage matches 320 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999
execute if score reactor sabotage matches 360 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999
execute if score reactor sabotage matches 400 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999
execute if score reactor sabotage matches 440 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999
execute if score reactor sabotage matches 480 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999
execute if score reactor sabotage matches 520 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999
execute if score reactor sabotage matches 560 run execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999

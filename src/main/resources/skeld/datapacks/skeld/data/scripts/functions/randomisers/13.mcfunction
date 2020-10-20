## 0 to 4
scoreboard objectives add var dummy
scoreboard players set pos13 var 13

summon tropical_fish 0 255 0
tag @e[type=tropical_fish] add rand
execute as @e[tag=rand] store result score var bossbar_timer run data get entity @s Variant
execute as @e[tag=rand] at @s run tp @s 0 -1000 0
scoreboard players operation var bossbar_timer %= pos13 var
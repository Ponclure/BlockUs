## 0 to 6
scoreboard objectives add var dummy
scoreboard players set pos7 var 7

summon tropical_fish 0 255 0
tag @e[type=tropical_fish] add rand
execute as @e[tag=rand] store result score var2 var run data get entity @s Variant
execute as @e[tag=rand] at @s run tp @s 0 -1000 0
scoreboard players operation var2 var %= pos7 var
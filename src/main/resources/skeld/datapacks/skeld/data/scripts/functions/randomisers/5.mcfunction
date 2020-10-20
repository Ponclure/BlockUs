## 0 to 4
scoreboard objectives add var dummy
scoreboard players set pos5 var 5

summon tropical_fish 0 255 0
tag @e[type=tropical_fish] add rand
execute as @e[tag=rand] store result score var1 var run data get entity @s Variant
execute as @e[tag=rand] at @s run tp @s 0 -1000 0
scoreboard players operation var1 var %= pos5 var
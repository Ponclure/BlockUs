tag @s remove surveil
tag @s remove to_c1
tag @s remove to_c2
tag @s remove to_c3
tag @s remove to_c4

execute if score comms sabotage matches -1 as @s at @s run playsound minecraft:camera master @s ~ ~ ~ 9999

tp @s @e[tag=camera_marker,limit=1]
clear @s
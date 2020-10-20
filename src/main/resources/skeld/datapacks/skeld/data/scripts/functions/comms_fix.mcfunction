execute if block -247 78 -223 minecraft:lime_concrete_powder if score comms sabotage matches 1.. run execute as @a at @s run playsound minecraft:task_completed master @s ~ ~ ~ 9999
execute if block -247 78 -223 minecraft:lime_concrete_powder if score comms sabotage matches 1.. run title @a title {"text":""}
execute if block -247 78 -223 minecraft:lime_concrete_powder if score comms sabotage matches 1.. run title @a subtitle {"text":"Comms restored"}

execute if block -247 78 -223 minecraft:lime_concrete_powder run scoreboard players set comms sabotage -1

setblock -247 77 -224 stone_button[face=floor,facing=south,powered=false] 
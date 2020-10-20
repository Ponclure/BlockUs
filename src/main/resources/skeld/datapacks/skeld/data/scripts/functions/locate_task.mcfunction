execute if score comms sabotage matches 0.. run playsound minecraft:comms_down master @s
execute if score comms sabotage matches 0.. run tellraw @s ["",{"text":"\n"},{"text":" Comms are down"},{"text":"\n"}]

execute if score comms sabotage matches -1 run playsound minecraft:generic master @s
execute if score comms sabotage matches -1 run tellraw @s[tag=crewmate] ["",{"text":"\n"},{"text":" You have a Task in: ","color":"white"},{"selector":"@e[tag=incomplete,limit=1,sort=random]","color":"green"},{"text":"\n"}]
execute if score comms sabotage matches -1 run tellraw @s[tag=impostor] ["",{"text":"\n"},{"text":" Crewmates have a Task in: ","color":"white"},{"selector":"@e[tag=incomplete,limit=1,sort=random]","color":"green"},{"text":"\n"}]

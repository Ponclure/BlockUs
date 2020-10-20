scoreboard players set o2 sabotage 600
scoreboard players set cd sabotage 2000000
scoreboard players set cd_doors sabotage 600
clear @a carrot_on_a_stick{display:{Name:'{"text":"Sabotage O2","italic":"false"}'},HideFlags:63,CustomModelData:9}
clear @a carrot_on_a_stick{display:{Name:'{"text":"Sabotage Reactor","italic":"false"}'},HideFlags:63,CustomModelData:10}
clear @a carrot_on_a_stick{display:{Name:'{"text":"Sabotage Comms","italic":"false"}'},HideFlags:63,CustomModelData:11}
clear @a carrot_on_a_stick{display:{Name:'{"text":"Sabotage Lights","italic":"false"}'},HideFlags:63,CustomModelData:12}
clear @a carrot_on_a_stick{display:{Name:'{"text":"Sabotage Doors","italic":"false"}'},HideFlags:63,CustomModelData:13}
execute as @a at @s run playsound minecraft:meltdown master @s ~ ~ ~ 9999

execute as @e[tag=o2_sabotage,limit=5,sort=random] at @s run setblock ~ ~ ~ lever[face=wall,facing=south,powered=false]
scoreboard players set lights sabotage 1
scoreboard players set cd sabotage 340
scoreboard players set cd_doors sabotage 340
clear @a carrot_on_a_stick{display:{Name:'{"text":"Sabotage O2","italic":"false"}'},HideFlags:63,CustomModelData:9}
clear @a carrot_on_a_stick{display:{Name:'{"text":"Sabotage Reactor","italic":"false"}'},HideFlags:63,CustomModelData:10}
clear @a carrot_on_a_stick{display:{Name:'{"text":"Sabotage Comms","italic":"false"}'},HideFlags:63,CustomModelData:11}
clear @a carrot_on_a_stick{display:{Name:'{"text":"Sabotage Lights","italic":"false"}'},HideFlags:63,CustomModelData:12}
clear @a carrot_on_a_stick{display:{Name:'{"text":"Sabotage Doors","italic":"false"}'},HideFlags:63,CustomModelData:13}
execute as @a at @s run playsound minecraft:entity.silverfish.ambient master @s ~ ~ ~ 9999 2

title @a title {"text":""}
title @a subtitle {"text":"Lights are down"}

fill -284 78 -241 -280 78 -241 lever[powered=false,face=wall,facing=south]
fill -284 77 -242 -280 77 -242 redstone_lamp[lit=false]


scoreboard objectives add inspect_sample dummy
execute as @a at @s run playsound minecraft:block.brewing_stand.brew master @s ~ ~ ~ 9999

## Crewmate/Impostor
scoreboard players set inspect_sample inspect_sample 900
setblock -280 77 -256 air
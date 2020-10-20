execute as @a at @s run playsound minecraft:block.brewing_stand.brew master @s ~ ~ ~ 9999

execute as @e[tag=med_bay,tag=inspect_sample,limit=1] run function scripts:decrement_task
function scripts:reset_tasks/med_bay/inspect_sample
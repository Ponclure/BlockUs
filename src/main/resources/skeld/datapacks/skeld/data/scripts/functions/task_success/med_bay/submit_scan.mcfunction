execute as @e[tag=submit_scan,tag=med_bay] at @s as @p[distance=..5] at @s run playsound minecraft:block.beacon.deactivate master @s ~ ~ ~ 9999

execute as @e[tag=med_bay,tag=submit_scan,limit=1] run function scripts:decrement_task
function scripts:reset_tasks/med_bay/submit_scan
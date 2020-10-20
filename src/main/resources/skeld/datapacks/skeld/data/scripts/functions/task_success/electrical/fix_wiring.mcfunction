execute as @a[x=-240,y=201,z=-324,dx=6,dy=3,dz=1] at @s run playsound minecraft:task_completed master @s ~ ~ ~ 9999
tp @a[x=-240,y=201,z=-324,dx=6,dy=3,dz=1] @e[tag=electrical,tag=fix_wiring,limit=1]

execute as @e[tag=electrical,tag=fix_wiring,limit=1] run function scripts:decrement_task
function scripts:reset_tasks/electrical/fix_wiring

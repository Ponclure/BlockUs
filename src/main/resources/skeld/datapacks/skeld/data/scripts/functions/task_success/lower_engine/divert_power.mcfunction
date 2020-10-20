execute as @a[x=-280,y=201,z=-313,dx=6,dy=3,dz=1] at @s run playsound minecraft:task_completed master @s ~ ~ ~ 9999
tp @a[x=-280,y=201,z=-313,dx=6,dy=3,dz=1] @e[tag=lower_engine,tag=divert_power,limit=1]

execute as @e[tag=lower_engine,tag=divert_power,limit=1] run function scripts:decrement_task
function scripts:reset_tasks/lower_engine/divert_power
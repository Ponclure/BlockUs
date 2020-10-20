execute as @a[x=-270,y=201,z=-302,dx=6,dy=3,dz=1] at @s run playsound minecraft:task_completed master @s ~ ~ ~ 9999
tp @a[x=-270,y=201,z=-302,dx=6,dy=3,dz=1] @e[tag=upper_engine,tag=divert_power,limit=1]

execute as @e[tag=upper_engine,tag=divert_power,limit=1] run function scripts:decrement_task
function scripts:reset_tasks/upper_engine/divert_power
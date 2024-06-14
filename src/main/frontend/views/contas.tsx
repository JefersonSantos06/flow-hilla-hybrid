import {ViewConfig} from '@vaadin/hilla-file-router/types.js';

export const config: ViewConfig = {
  menu: { order: 1, icon: 'line-awesome/svg/globe-solid.svg' },
  title: 'Contas',
  rolesAllowed: ['USER'],
};

export default function ContasView() {
  return (
    <>
      <section className="flex p-m gap-m items-end">

      </section>
    </>
  );
}
